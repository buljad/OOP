package ru.nsu.izhuravskii;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A launch of my pizzeria.
 */
public class Main{
    public static void main(String[] args){
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
        }, 10000);
        while(!cancelFlag[0]) {
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
