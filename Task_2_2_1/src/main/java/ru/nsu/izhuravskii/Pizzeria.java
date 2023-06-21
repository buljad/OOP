package ru.nsu.izhuravskii;

import static java.lang.Math.ceil;
import static java.lang.Math.min;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This module describe how exactly pizzeria works.
 */
public class Pizzeria {
    private static final  Deque<Order> orderQueue = new ArrayDeque<>();
    private static Deque<Order> stockQueue;
    private final List<Cook> cooks;
    private final List<Deliver> delivers;
    static int totalCapacity = 0;
    private final ExecutorService cooksPool;
    private final ExecutorService deliversPool;

    /**
     * Initialization of pizzeria.
     *
     * @param file - json file from with info
     *             about cooks and delivers.
     */
    public Pizzeria(String file) {
        JsonData jsonData = new JsonData(file);
        stockQueue = new ArrayDeque<>(jsonData.getStockCapacity());
        this.cooks = jsonData.getCooks();
        this.delivers = jsonData.getDelivers();
        totalCapacity = delivers.stream().mapToInt(Deliver::getCapacity).sum();
        cooksPool = Executors.newFixedThreadPool(cooks.size());
        deliversPool = Executors.newFixedThreadPool(delivers.size());
    }

    /**
     * This module starts pools of cooks and delivers threads.
     */
    public void openPizzeria() {
        cooks.forEach(cooksPool::submit);
        delivers.forEach(deliversPool::submit);
    }

    /**
     * Module describes how cook can take an order
     * to begin working.
     *
     * @return - first order from the orders queue.
     * @throws InterruptedException - in case of program interruption.
     */
    public static Order takeOrder() throws InterruptedException {
        synchronized (orderQueue) {
            while (orderQueue.isEmpty()) {
                orderQueue.wait();
            }
            return orderQueue.pollFirst();
        }
    }

    /**
     * Module of making a new order.
     *
     * @param order - an order to make.
     * @throws InterruptedException - in case of program interruption.
     */
    public void addOrder(Order order) throws InterruptedException {
        synchronized (orderQueue) {
            orderQueue.add(order);
            order.setStatus(Order.Status.ORDERED);
            orderQueue.notifyAll();
        }
    }

    /**
     * Module for moving a cooked order to stock.
     *
     * @param order - order to stock.
     * @throws InterruptedException - in case of program interruption.
     */
    public static void stockOrder(Order order) throws InterruptedException {
        synchronized (stockQueue) {
            stockQueue.add(order);
            stockQueue.notifyAll();
            order.setStatus(Order.Status.IN_STOCK);
            System.out.println(order);
        }
    }

    /**
     * This module shows how deliver can take some amount
     * of orders to deliver.
     *
     * @param capacity - delivers' capacity
     * @return - returns amount of orders
     * @throws InterruptedException - in case of program interruption
     */
    public static List<Order> takeFromStock(int capacity) throws InterruptedException {
        synchronized (stockQueue) {
            while (stockQueue.isEmpty()) {
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

    public void closePizzeria() {
        cooksPool.shutdownNow();
        deliversPool.shutdownNow();
    }
}
