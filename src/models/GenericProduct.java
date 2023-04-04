package models;

public class GenericProduct {
    private int productId;
    private int sellerId;
    private String productName;
    private float price;
    private int stock;
    private String brand;

    public GenericProduct(int productId, int sellerId, String productName, float price, int stock, String brand) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
    }

}
