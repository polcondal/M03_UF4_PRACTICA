package models;

public class Technology extends GenericProduct {
    String model;
    String serialNumber;

    public Technology(int productId, int sellerId, String productName, float price, int stock, String brand, String model, String serialNumber) {
        super(productId, sellerId, productName, price, stock, brand);
        this.model = model;
        this.serialNumber = serialNumber;
    }
}
