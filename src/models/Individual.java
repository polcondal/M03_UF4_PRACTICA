package models;

import interfaces.ManageOrders;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Individual extends Client implements ManageOrders {
    String fullName;
    LocalDateTime birthDate;
    int points;
    /* chechkpoints(); */

    public Individual(int idClient, int phoneNumber, String email, String address, String loginName, String loginPassword, ArrayList<Order> clientOrders, String fullName, LocalDateTime birthDate, int points) {
        super(idClient, phoneNumber, email, address, loginName, loginPassword, clientOrders);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.points = points;
    }
}
