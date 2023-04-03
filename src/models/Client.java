package models;

import interfaces.UserAccount;

import java.util.ArrayList;

public class Client implements UserAccount {
    final int idClient;
    int phoneNumber;
    String email;
    String address;
    String loginName;
    String loginPassword;
    ArrayList <Order> clientOrders;

    public Client(int idClient, int phoneNumber, String email, String address, String loginName, String loginPassword, ArrayList<Order> clientOrders) {
        this.idClient = idClient;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.clientOrders = clientOrders;
    }
}


