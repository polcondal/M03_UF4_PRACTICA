package models;

public class Technology extends GenericProduct {
    public Technology(int productId, int sellerId, String productName, float price, int stock, String brand) {
        super(productId, sellerId, productName, price, stock, brand);
    }
}
