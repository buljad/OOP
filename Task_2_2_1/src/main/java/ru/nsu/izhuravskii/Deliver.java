package ru.nsu.izhuravskii;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Deliver implements Runnable{
    Queue<String> currentOrders;
    String name;
    int deliverySkill;

    boolean isOnTheWay = false;
    int capacity;

    public int getCapacity() {
        return capacity;
    }

    public boolean isOnTheWay() {
        return isOnTheWay;
    }
    public Deliver(String name, int deliverySkill, int capacity) {
        this.name = name;
        this.deliverySkill = deliverySkill;
        this.capacity = capacity;
    }
    @Override
    public void run() {
        //Order order = null;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                List<Order> orders = Pizzeria.takeFromStock(capacity);
                for (Order order : orders) {
                    order.setStatus(Order.Status.DELIVERING);
                    System.out.println(order + " by " + name);
                    TimeUnit.SECONDS.sleep(10 / deliverySkill);
                    order.setStatus(Order.Status.DELIVERED);
                    System.out.println(order + " by " + name);
                }
                isOnTheWay = false;
                System.out.println(name + " is going back");
                TimeUnit.SECONDS.sleep(10 / deliverySkill);
                System.out.println(name + " is ready to deliver");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
