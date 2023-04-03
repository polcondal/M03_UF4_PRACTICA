package models;

import interfaces.UserAccount;

import java.util.ArrayList;

public class Seller implements UserAccount {
    int sellerId;
    String sellerName;
    String loginPassword;
    String loginName;
    ArrayList <GenericProduct> sellerProducts;

    /*AddProduct();
    DeleteProduct();
    ModifyProduct();*/


    public Seller(int sellerId, String sellerName, String loginPassword, String loginName, ArrayList<GenericProduct> sellerProducts) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.loginPassword = loginPassword;
        this.loginName = loginName;
        this.sellerProducts = sellerProducts;
    }
    public static void AddProduct (ArrayList <GenericProduct> sellerProducts){
    }



}
