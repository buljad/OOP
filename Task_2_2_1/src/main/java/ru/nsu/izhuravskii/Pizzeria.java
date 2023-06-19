package ru.nsu.izhuravskii;

import static java.lang.Math.ceil;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    private static volatile BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private static volatile BlockingQueue<Order> stockQueue;
    private List<Cook> cooks;
    private List<Deliver> delivers;
    static int totalBagCapacity = 0;
    private final ExecutorService cooksPool;
    private final ExecutorService deliversPool;

    public Pizzeria(String file) {
        JsonData jsonData = new JsonData(file);
        stockQueue = new LinkedBlockingQueue<>(jsonData.getStockCapacity());
        this.cooks = jsonData.getCooks();
        this.delivers = jsonData.getDelivers();
        totalBagCapacity = delivers.stream().mapToInt(Deliver::getCapacity).sum();
        cooksPool = Executors.newFixedThreadPool(cooks.size());
        deliversPool = Executors.newFixedThreadPool(delivers.size());
    }

    public void openPizzeria() {
        cooks.forEach(cooksPool::submit);
        delivers.forEach(deliversPool::submit);
    }

    public static Order takeOrder() throws InterruptedException {
        return orderQueue.take();
    }

    public void addOrder(Order order) throws InterruptedException {
        orderQueue.put(order);
        order.setStatus(Order.Status.ORDERED);
    }


    public static void stockOrder(Order order) throws InterruptedException {
        stockQueue.put(order);
        order.setStatus(Order.Status.IN_STOCK);
        System.out.println(order);
    }

    public static List<Order> takeFromStock(int capacity) throws InterruptedException {
        List<Order> orders = new ArrayList<>();
        int count = (int) min(ceil(
                ((double) stockQueue.size() / totalBagCapacity) * capacity + 1), capacity);
        for (int i = 0; i < count; i++) {
            orders.add(stockQueue.take());
        }
        return orders;
    }
    public void closePizzeria() throws InterruptedException {
        while (true) {
            if (orderQueue.isEmpty() && cooks.stream().noneMatch(Cook::isCooking)) {
                cooksPool.shutdown();
                System.out.println("Cooks are going home");
                break;
            }
        }
        while (true) {
            if (stockQueue.isEmpty() && delivers.stream().noneMatch(Deliver::isOnTheWay)) {
                deliversPool.shutdown();
                System.out.println("Delivers are going home");
                break;
            }
        }
    }
}
