package ru.nsu.izhuravskii;

import static java.lang.Math.ceil;
import static java.lang.Math.min;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pizzeria {
    private final static Deque<Order> orderQueue = new ArrayDeque<>();
    private static Deque<Order> stockQueue;
    private final List<Cook> cooks;
    private final List<Deliver> delivers;
    static int totalCapacity = 0;
    private final ExecutorService cooksPool;
    private final ExecutorService deliversPool;

    public Pizzeria(String file) {
        JsonData jsonData = new JsonData(file);
        stockQueue = new ArrayDeque<>(jsonData.getStockCapacity());
        this.cooks = jsonData.getCooks();
        this.delivers = jsonData.getDelivers();
        totalCapacity = delivers.stream().mapToInt(Deliver::getCapacity).sum();
        cooksPool = Executors.newFixedThreadPool(cooks.size());
        deliversPool = Executors.newFixedThreadPool(delivers.size());
    }

    public void openPizzeria() {
        cooks.forEach(cooksPool::submit);
        delivers.forEach(deliversPool::submit);
    }

    public static Order takeOrder() throws InterruptedException {
        synchronized (orderQueue) {
            while (orderQueue.isEmpty()) {
                orderQueue.wait();
            }
            return orderQueue.pollFirst();
        }
    }

    public void addOrder(Order order) throws InterruptedException {
        synchronized(orderQueue) {
            orderQueue.add(order);
            order.setStatus(Order.Status.ORDERED);
            orderQueue.notifyAll();
        }
    }


    public static void stockOrder(Order order) throws InterruptedException {
        synchronized (stockQueue) {
                stockQueue.add(order);
                stockQueue.notifyAll();
                order.setStatus(Order.Status.IN_STOCK);
                System.out.println(order);
        }
    }

    public static List<Order> takeFromStock(int capacity) throws InterruptedException {
        synchronized (stockQueue) {
            while(stockQueue.isEmpty()) {
                stockQueue.wait();
            }
            List<Order> orders = new ArrayList<>();
            int count = (int) min(ceil(
                    ((double) stockQueue.size() / totalCapacity) * capacity + 1), capacity);
            for (int i = 0; i < count; i++) {
                orders.add(stockQueue.pollFirst());
            }
            return orders;
        }
    }
    public void closePizzeria(){
            cooksPool.shutdownNow();
            deliversPool.shutdownNow();
    }
}
