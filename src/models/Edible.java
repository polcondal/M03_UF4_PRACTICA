package models;

import java.util.ArrayList;


public class Edible extends GenericProduct{

    boolean isFresh;
    boolean hasAlcohol;
    ArrayList<GenericProduct> edibles;


    public Edible(int productId, int sellerId, String productName, float price, int stock, String brand, boolean isFresh, boolean hasAlcohol) {
        super(productId, sellerId, productName, price, stock, brand);
        this.isFresh = isFresh;
        this.hasAlcohol = hasAlcohol;
        this.edibles = new ArrayList<>();
    }




}
