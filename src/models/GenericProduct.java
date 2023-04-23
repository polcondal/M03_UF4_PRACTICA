package models;

public abstract class GenericProduct {
    private static int productIdCounter = 0;
    private int productId;
    private String supplierName;
    private String productName;
    private float price;
    private int stock;
    private String brand;

    public GenericProduct(String supplierName, String productName, float price, int stock, String brand) {
        productIdCounter++;
        this.productId = productIdCounter;
        this.supplierName = supplierName;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
    }


    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "GenericProduct{" +
                "productId=" + productId +
                ", supplierName='" + supplierName + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", brand='" + brand + '\'' +
                '}';
    }


}
