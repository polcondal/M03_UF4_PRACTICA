package models;

import interfaces.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Individual extends Client implements ManageOrders, UserAccount {
    private String fullName;
    private Date birthDate;

    public Individual(int phoneNumber, String email, String address, String loginName,
                      String loginPassword, ArrayList<Order> clientOrders, String fullName, Date birthDate) {
        super(phoneNumber, email, address, loginName, loginPassword, clientOrders);
        this.fullName = fullName;
        this.birthDate = birthDate;
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
