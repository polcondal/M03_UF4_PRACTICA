package models;

import models.enums.EdibleCategory;

public class Edible extends GenericProduct{
    private EdibleCategory edibleCategory;

    //constructor directo
    public Edible(String supplierName, String productName, float price, int stock, String brand, EdibleCategory edibleCategory) {
        super(supplierName, productName, price, stock, brand);
        this.edibleCategory = edibleCategory;
    }

    public EdibleCategory getEdibleCategory() {
        return edibleCategory;
    }
    public void setEdibleCategory(EdibleCategory edibleCategory) {
        this.edibleCategory = edibleCategory;
    }

}
