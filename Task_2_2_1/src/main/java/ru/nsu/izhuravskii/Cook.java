package ru.nsu.izhuravskii;

import java.util.concurrent.TimeUnit;

public class Cook implements Runnable {
    String name;
    int skill;
    public Cook(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }
    boolean isCooking = false;
    public boolean isCooking() {
        return isCooking;
    }
    @Override
    public void run() {
        try {
            Order order = Pizzeria.takeOrder();
            isCooking = true;
            order.setStatus(Order.Status.COOKING);
            System.out.println(order);
            TimeUnit.SECONDS.sleep(10 / skill);
            order.setStatus(Order.Status.COOKED);
            isCooking = false;
            System.out.println(order);
            Pizzeria.stockOrder(order);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
