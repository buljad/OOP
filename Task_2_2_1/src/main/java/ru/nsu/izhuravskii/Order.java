package ru.nsu.izhuravskii;

/**
 * Class of describing orders
 * of my pizzeria.
 */
public class Order {
    private final int id;

    /**
     * Description of states of order.
     */
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

    /**
     * This method showing how to order.
     */
    public Order() {
        this.id = id_counter;
        this.status = Status.ORDERED;
        id_counter++;
    }

    @Override
    public String toString() {
        return "Order {"
                + "id = " + id
                + ", status = "
                + status
                + '}';
    }
}
