package models;

import interfaces.UserAccount;
import utils.Utilities;
import java.util.ArrayList;


public abstract class Client extends User implements UserAccount{
    private int phoneNumber;
    private String email;
    private String address;
    private ArrayList<Order> clientOrders;

    public Client(String username, String password) {
        super(username, password);
    }

    //phone number
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber() {
        return this.phoneNumber;
    }
    //email
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    //address
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }


    public void showOrders(){
        for (Order order : this.clientOrders) {
            System.out.println(order);
        }
    }

    @Override
    public void createAccount() {
        // TODO: MIRAR SI REALMENTE ES UN MAIL Y QUE NO EXISTA YA EN LA LISTA DE USUARIOS
        this.setEmail(Utilities.leerMail("Introduce tu email: "));

        this.setAddress(Utilities.leerFrase("Introduce tu dirección: ", 8));
        this.setPhoneNumber(Utilities.leerInt("Introduce tu número de teléfono: ", 100000000, 999999999));
    }


    @Override
    public void modifyAccount() {

    }
}
