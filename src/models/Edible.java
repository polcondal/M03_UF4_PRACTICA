package models;

import java.util.ArrayList;

public class Edible extends GenericProduct {
    private boolean isFresh;
    private boolean hasAlcohol;

    public Edible(int productId, int sellerId, String productName, float price, int stock, String brand,
            boolean isFresh, boolean hasAlcohol) {
        super(productId, sellerId, productName, price, stock, brand);
        this.isFresh = isFresh;
        this.hasAlcohol = hasAlcohol;
    }

}
