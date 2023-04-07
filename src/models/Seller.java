package models;

import interfaces.UserAccount;

import java.util.ArrayList;

public class Seller extends User implements UserAccount {
    private String storeName;
    private ArrayList<GenericProduct> sellerProducts;

    public Seller(int sellerId, String storeName, String loginPassword, String loginName,
            ArrayList<GenericProduct> sellerProducts) {
        super(sellerId, loginPassword, loginName);
        this.storeName = storeName;
        this.sellerProducts = sellerProducts;
    }

    public void AddProduct(ArrayList<GenericProduct> sellerProducts) {
        // TODO implement here
    }

    public void DeleteProduct(ArrayList<GenericProduct> sellerProducts) {
        // TODO implement here
    }

    public void ModifyProduct(ArrayList<GenericProduct> sellerProducts) {
        // TODO implement here
    }

    @Override
    public void CreateAccount() {

    }

    @Override
    public void RemoveAccount() {

    }

    @Override
    public void ModifyAccount() {

    }
}
