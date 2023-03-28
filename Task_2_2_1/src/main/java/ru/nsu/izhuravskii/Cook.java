package ru.nsu.izhuravskii;

public class Cook implements Runnable {
    String name;
    int experience;
    public Cook(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    @Override
    public void run() {

    }
}
