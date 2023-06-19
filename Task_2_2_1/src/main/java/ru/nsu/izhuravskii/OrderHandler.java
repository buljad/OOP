package ru.nsu.izhuravskii;

import java.util.Scanner;

public class OrderHandler implements Runnable {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        Pizzeria pizzeria = new Pizzeria("pizzeriaData.json");
        pizzeria.openPizzeria();
        System.out.println("Pizzeria is opened");
        while(true) {
            if (scanner.hasNextInt()) {
                int size = scanner.nextInt();
                if (size == -1) {
                    try {
                        pizzeria.closePizzeria();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Pizzeria is closed");
                    return;
                }
                for (int i = 0; i < size; i++) {
                    try {
                        Order newOrder = new Order();
                        pizzeria.addOrder(newOrder);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
