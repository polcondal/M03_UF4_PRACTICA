package models;

import utils.Utilities;


public class Supplier extends User {
    private String supplierName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    //Constructor directo defaultData
    public Supplier(String userName, String loginPassword, String supplierName) {
        super(userName, loginPassword);
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "Supplier [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ']';
    }

}
