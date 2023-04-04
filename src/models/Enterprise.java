package models;

import interfaces.*;

import java.util.ArrayList;

public class Enterprise extends Client implements ManageOrders, UserAccount {
    final private String cif;
    private String enterpriseName;

    public Enterprise(int idClient, int phoneNumber, String email, String address, String loginName,
            String loginPassword, ArrayList<Order> clientOrders, String cif, String enterpriseName) {
        super(idClient, phoneNumber, email, address, loginName, loginPassword, clientOrders);
        this.cif = cif;
        this.enterpriseName = enterpriseName;
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
