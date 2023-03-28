package ru.nsu.izhuravskii;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    private List<Cook> cooks;
    private List<Deliver> delivers;
    private final Queue<Order> orders = new LinkedBlockingQueue<>();
    public Pizzeria() {
        Queue<String> stock = new LinkedBlockingQueue<>(123);
    }
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    private List<Cook> hireCooks() {

        return null;
    }

    private List<Deliver> hireDelivers() {

        return null;
    }

}
