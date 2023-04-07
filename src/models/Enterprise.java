package models;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Enterprise extends Client implements ManageOrders, UserAccount {
    final private String cif;
    private String enterpriseName;

    public Enterprise(int phoneNumber, String email, String address, String loginName,
                      String loginPassword, ArrayList<Order> clientOrders, String cif, String enterpriseName) {
        super(phoneNumber, email, address, loginName, loginPassword, clientOrders);
        this.cif = cif;
        this.enterpriseName = enterpriseName;
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void removeAccount() {

    }

    @Override
    public void modifyAccount() {

    }
}
