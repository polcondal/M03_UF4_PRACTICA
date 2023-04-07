package models;

import models.enums.EdibleCategory;

public class Edible extends GenericProduct{
    private EdibleCategory edibleCategory;

    public Edible(int productId, int sellerId, String productName, float price, int stock, String brand) {
        super(productId, sellerId, productName, price, stock, brand);
    }

    public EdibleCategory getEdibleCategory() {
        return edibleCategory;
    }
    public void setEdibleCategory(EdibleCategory edibleCategory) {
        this.edibleCategory = edibleCategory;
    }

}
