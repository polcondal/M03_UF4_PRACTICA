package models;

public class Edible extends GenericProduct{
    private String edibleDescription;

    //constructor directo
    public Edible(String supplierName, String productName, float price, int stock, String brand, String edibleDescription) {
        super(supplierName, productName, price, stock, brand);
        this.edibleDescription = edibleDescription;
    }


}
