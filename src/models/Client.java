package models;

import interfaces.UserAccount;
import utils.Utilities;
import java.util.ArrayList;


public abstract class Client extends User implements  UserAccount{
    private int phoneNumber;
    private String email;
    private String address;
    private ArrayList<Order> clientOrders;


    public Client(String username, String password) {
        super(username, password);
    }


    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return this.email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }



    public Client(int phoneNumber, String email, String address, String loginName, String loginPassword,
                  ArrayList<Order> clientOrders) {
        super(loginName,loginPassword );
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.clientOrders = clientOrders;
    }

    @Override
    public void createAccount() {
        // TODO: MIRAR SI REALMENTE ES UN MAIL Y QUE NO EXISTA YA EN LA LISTA DE USUARIOS
        this.setEmail(Utilities.leerMail("Introduce tu email: "));

        this.setAddress(Utilities.leerFrase("Introduce tu dirección: ", 8));
        this.setPhoneNumber(Utilities.leerInt("Introduce tu número de teléfono: ", 100000000, 999999999));
    }

    @Override
    public void removeAccount() {

    }

    @Override
    public void modifyAccount() {

    }
}
