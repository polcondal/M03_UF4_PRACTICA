package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private static int orderIdCounter = 0;
    private int orderId;
    private GenericProduct products;
    private LocalDate orderCreationDate;
    private LocalDate orderArrivalDate;

    public Order(GenericProduct products, LocalDate orderCreationDate,
                 LocalDate orderArrivalDate) {
        orderIdCounter++;
        this.orderId = orderIdCounter;
        this.products = products;
        this.orderCreationDate = orderCreationDate;
        this.orderArrivalDate = orderArrivalDate;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public GenericProduct getProducts() {
        return products;
    }
    public void setProducts(GenericProduct products) {
        this.products = products;
    }

    public LocalDate getOrderCreationDate() {
        return orderCreationDate;
    }
    public void setOrderCreationDate(LocalDate orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public LocalDate getOrderArrivalDate() {
        return orderArrivalDate;
    }
    public void setOrderArrivalDate(LocalDate orderArrivalDate) {
        this.orderArrivalDate = orderArrivalDate;
    }

    @Override
    public String toString() {

        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                ", orderCreationDate=" + orderCreationDate +
                ", orderArrivalDate=" + orderArrivalDate +
                '}';
    }


}
