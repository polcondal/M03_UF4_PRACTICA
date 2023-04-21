package models;

import java.util.ArrayList;

public class ProductList {

    private static ArrayList<GenericProduct> products = new ArrayList<GenericProduct>();

    public static void addProduct(GenericProduct product){
        products.add(product);
    }

    public static ArrayList<GenericProduct> getProductsArrayList(){
        return products;
    }



    public static void removeProduct(int productId){
        products.remove(productId);
    }
}
