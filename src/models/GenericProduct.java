package models;
public class GenericProduct {
    int productId;
    int sellerId;
    String productName;
    float price;
    int stock;
    String brand;

    public GenericProduct(int productId, int sellerId, String productName, float price, int stock, String brand) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
    }
    GenericProduct cocacola = new GenericProduct(1,1, "cocacola", 1, 1, "Cocacola Company");

    public GenericProduct getCocacola() {
        return cocacola;
    }
}
