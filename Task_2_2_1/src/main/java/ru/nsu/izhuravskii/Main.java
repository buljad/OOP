package ru.nsu.izhuravskii;

public class Main {
    public static void main(String[] args){
        OrderHandler orderHandler = new OrderHandler();
        (new Thread(orderHandler)).start();
    }
}
