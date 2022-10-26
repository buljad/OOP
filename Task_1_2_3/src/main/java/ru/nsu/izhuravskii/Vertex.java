package ru.nsu.izhuravskii;

public class Vertex<T> {
    private T value;
    private int number;
    private boolean enterStatus;
    private int vertCounter = 0;
    public void VertexInit(T val) {
        this.value = val;
        this.number = vertCounter;
        vertCounter++;
        this.enterStatus = false;
    }
}
