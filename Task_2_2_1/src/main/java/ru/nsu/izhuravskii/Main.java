package ru.nsu.izhuravskii;

import java.util.Scanner;
import java.util.Timer;

/**
 * Realization of my pizzeria.
 */
public class Main {
    /**
     * A launch of my pizzeria.
     * It gets data about cooks and delivers
     * from pizzeriaData.json
     *
     * @param args - main module's parameters
     *             to read input from terminal
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizzeria pizzeria = new Pizzeria("pizzeriaData.json");
        pizzeria.openPizzeria();
        System.out.println("Pizzeria is opened");
        Timer timer = new Timer();
        final boolean[] cancelFlag = {false};
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                pizzeria.closePizzeria();
                timer.cancel();
                System.out.println("Pizzeria is closed");
                cancelFlag[0] = true;
            }
        }, 30000);
        while (!cancelFlag[0]) {
            if (scanner.hasNextInt()) {
                int size = scanner.nextInt();
                if (size == -1) {
                    pizzeria.closePizzeria();
                    System.out.println("Pizzeria is closed");
                    timer.cancel();
                    break;
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
