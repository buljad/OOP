package ru.nsu.izhuravskii;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Deliver implements Runnable{
    Queue<String> currentOrders;
    String name;
    int deliverySkill;
    int capacity;
    public Deliver(String name, int deliverySkill, int capacity) {
        this.name = name;
        this.deliverySkill = deliverySkill;
        this.capacity = capacity;
    }
    @Override
    public void run() {
        Order order = null;
        try {
            order = Pizzeria.takeFromStock();
            order.setStatus(Order.Status.DELIVERING);
            System.out.println(order);
            TimeUnit.SECONDS.sleep(10 / deliverySkill);
            order.setStatus(Order.Status.DELIVERED);
            System.out.println(order);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
