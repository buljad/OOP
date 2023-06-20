package ru.nsu.izhuravskii;

import java.util.Scanner;

/**
 * A launch of my pizzeria.
 */
public class Main implements Runnable{
    public static void main(String[] args){
        Main work = new Main();
        new Thread(work).start();
    }
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
