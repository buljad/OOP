package ru.nsu.izhuravskii;

/**
 * A launch of my pizzeria.
 */
public class Main {
    public static void main(String[] args){
        OrderHandler orderHandler = new OrderHandler();
        (new Thread(orderHandler)).start();
    }
}
