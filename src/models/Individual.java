package models;

import interfaces.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Individual extends Client implements ManageOrders, UserAccount {
    private String fullName;
    private LocalDateTime birthDate;
    private int points;

    public Individual(int idClient, int phoneNumber, String email, String address, String loginName,
            String loginPassword, ArrayList<Order> clientOrders, String fullName, LocalDateTime birthDate, int points) {
        super(idClient, phoneNumber, email, address, loginName, loginPassword, clientOrders);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.points = points;
    }

    public int getPoints() {
        return this.points;
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
