package models;

import interfaces.ManageOrders;

import java.util.ArrayList;

public class Enterprise extends Client implements ManageOrders {
    final String cif;
    String enterpriseName;

    public Enterprise(int idClient, int phoneNumber, String email, String address, String loginName, String loginPassword, ArrayList<Order> clientOrders, String cif, String enterpriseName) {
        super(idClient, phoneNumber, email, address, loginName, loginPassword, clientOrders);
        this.cif = cif;
        this.enterpriseName = enterpriseName;
    }
}
