package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private ArrayList<GenericProduct> products;
    private LocalDateTime orderCreationDate;
    private LocalDate orderArrivalDate;

    public Order(int orderId, ArrayList<GenericProduct> products, LocalDateTime orderCreationDate,
            LocalDateTime orderArrivalDate) {
        this.orderId = orderId;
        this.products = products;
        this.orderCreationDate = orderCreationDate;
        this.orderArrivalDate = orderArrivalDate;
    }
}
