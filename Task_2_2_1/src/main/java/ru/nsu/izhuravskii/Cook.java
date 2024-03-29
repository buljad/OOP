package ru.nsu.izhuravskii;

import java.util.concurrent.TimeUnit;

/**
 * Module describing work of cooks.
 */
public class Cook implements Runnable {
    String name;
    int skill;
    boolean isCooking = false;

    public Cook(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Order order = Pizzeria.takeOrder();
                isCooking = true;
                order.setStatus(Order.Status.COOKING);
                System.out.println(order + " by " + name);
                TimeUnit.SECONDS.sleep(10 / skill);
                order.setStatus(Order.Status.COOKED);
                isCooking = false;
                System.out.println(order + " by " + name);
                Pizzeria.stockOrder(order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
