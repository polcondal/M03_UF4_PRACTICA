package models;

import interfaces.UserAccount;

import java.util.ArrayList;

public abstract class Client implements UserAccount {
    private final int idClient;
    private int phoneNumber;
    private String email;
    private String address;
    private String loginName;
    private String loginPassword;
    private ArrayList<Order> clientOrders;

    public Client(int idClient, int phoneNumber, String email, String address, String loginName, String loginPassword,
            ArrayList<Order> clientOrders) {
        this.idClient = idClient;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.clientOrders = clientOrders;
    }
}
