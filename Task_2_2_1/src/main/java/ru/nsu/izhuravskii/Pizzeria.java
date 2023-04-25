package ru.nsu.izhuravskii;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    private List<Cook> cooks;
    private List<Deliver> delivers;
    private static final BlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    private static BlockingQueue<Order> stock;
    public Pizzeria() {
        BlockingQueue<String> stock = new LinkedBlockingQueue<>(123);
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    public static Order takeOrder() throws InterruptedException {
        return(orders.take());
    }

    public static void stockOrder(Order order) throws InterruptedException {
        stock.put(order);
        order.setStatus(Order.Status.IN_STOCK);
        System.out.println(order);
    }

    public static Order takeFromStock(int capacity) throws InterruptedException {
        return(stock.take());
    }
    /*
    private List<Cook> hireCooks() {

        return null;
    }

    private List<Deliver> hireDelivers() {

        return null;
    }
    */
}
