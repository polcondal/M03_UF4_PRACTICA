package models;

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

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<GenericProduct> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<GenericProduct> products) {
        this.products = products;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }
    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public Date getOrderArrivalDate() {
        return orderArrivalDate;
    }
    public void setOrderArrivalDate(Date orderArrivalDate) {
        this.orderArrivalDate = orderArrivalDate;
    }



}
