package models;

public class Clothing extends GenericProduct{
    String size;
    String material;

    public Clothing(int productId, int sellerId, String productName, float price, int stock, String brand, String size, String material) {
        super(productId, sellerId, productName, price, stock, brand);
        this.size = size;
        this.material = material;
    }
}
