package models;

import interfaces.*;
import utils.Utilities;

public class Enterprise extends Client implements ManageOrders, UserAccount {
    final private String cif;
    private String enterpriseName;

    public Enterprise(String username, String password, String cif){
        super(username, password);
        this.setUsername(username);
        this.setPassword(password);
        this.cif = cif;
    };

    @Override
    public void createAccount() {
        //TODO: IMPLEMENTAR
        super.createAccount();
        this.enterpriseName = Utilities.leerFrase("Introduce el nombre de la empresa: ", 8);

    }


    @Override
    public void removeAccount() {

    }

    @Override
    public void modifyAccount() {

    }

    @Override
    public String toString() {
        return "Enterprise [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", cif='" + cif + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ']';
    }
}
