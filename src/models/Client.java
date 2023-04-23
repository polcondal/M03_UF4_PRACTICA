package models;

import java.util.ArrayList;



public abstract class Client extends User{
    private int phoneNumber;
    private String email;
    private String address;
    private ArrayList<Order> clientOrders;

    //constructor directo
    public Client(String username, String password, ArrayList<Order> clientOrders) {
        super(username, password);
    }

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


    public void addOrder(Order order){
        clientOrders.add(order);
    }

    public void showOrders(){
        for (Order order : this.clientOrders) {
            System.out.println(order);
        }
    }


}
