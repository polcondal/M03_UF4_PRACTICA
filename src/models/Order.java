package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int orderId;
    private ArrayList<GenericProduct> products;
    private Date orderCreationDate;
    private Date orderArrivalDate;

    public Order(int orderId, ArrayList<GenericProduct> products, Date orderCreationDate,
                 Date orderArrivalDate) {
        this.orderId = orderId;
        this.products = products;
        this.orderCreationDate = orderCreationDate;
        this.orderArrivalDate = orderArrivalDate;
    }
}
