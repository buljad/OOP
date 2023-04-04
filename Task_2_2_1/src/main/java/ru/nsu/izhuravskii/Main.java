package ru.nsu.izhuravskii;

public class Main {
    public static void main(String[] args) {
        OrderHandler Kirill = new OrderHandler();
        Thread cookingThread = new Thread(Kirill);
        cookingThread.start();
    }
}
