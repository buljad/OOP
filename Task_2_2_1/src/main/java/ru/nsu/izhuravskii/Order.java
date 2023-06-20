package ru.nsu.izhuravskii;

public class Order {
    private final int id;
    public enum Status {
        ORDERED,
        COOKING,
        COOKED,
        IN_STOCK,
        DELIVERING,
        DELIVERED
    }
    Status status;
    private static int id_counter = 0;

    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }

    public Order() {
        this.id = id_counter;
        this.status = Status.ORDERED;
        id_counter ++;
    }

    @Override
    public String toString() {
        return "Order {" +
                "id = " + id +
                ", status = " + status +
                '}';
    }
}