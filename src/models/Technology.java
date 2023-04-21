package models;

public class Technology extends GenericProduct {
    private int serialNumber;
    public Technology(String supplierName, String productName, float price, int stock, String brand, int serialNumber) {
        super(supplierName, productName, price, stock, brand);
        this.serialNumber = serialNumber;
    }
}
