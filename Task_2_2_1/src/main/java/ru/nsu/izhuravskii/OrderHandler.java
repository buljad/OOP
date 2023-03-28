package ru.nsu.izhuravskii;

import java.util.Scanner;

public class OrderHandler implements Runnable {

    Pizzeria pizzeria = new Pizzeria();

    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while(true) {
            int ordersNumber = scanner.nextInt();
            if(ordersNumber < 0) {
                break;
            } else {
                for (int i = 0; i < ordersNumber; i++) {
                    pizzeria.addOrder(new Order());
                }
            }
        }
    }
}
