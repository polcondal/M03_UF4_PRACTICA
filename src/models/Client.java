package models;

import interfaces.UserAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class Client extends User implements UserAccount {
    private int phoneNumber;
    private String email;
    private String address;
    private ArrayList<Order> clientOrders;

    public Client(int phoneNumber, String email, String address, String loginName, String loginPassword,
                  ArrayList<Order> clientOrders) {
        super(loginName,loginPassword );
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.clientOrders = clientOrders;
    }
}
