package models;

import utils.Utilities;

import java.util.ArrayList;

public class Enterprise extends Client {
    final private String cif;
    private String enterpriseName;

    public Enterprise(String username, String password, String cif, String enterpriseName, int phoneNumber, String email, String address, ArrayList<Order> enterpriseOrders){
        super(username, password, enterpriseOrders);
        this.cif = cif;
        this.enterpriseName = enterpriseName;
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setAddress(address);
        enterpriseOrders = new ArrayList<>();
    };

    public String getCif() {
        return cif;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public String toString() {
        return "Enterprise [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", cif='" + cif + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ']';
    }
}
