package models;

public class Technology extends GenericProduct {
    private String serialNumber;
    public Technology(String supplierName, String productName, float price, int stock, String brand, String serialNumber) {
        super(supplierName, productName, price, stock, brand);
        this.serialNumber = serialNumber;
    }
}
