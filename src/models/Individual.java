package models;

import interfaces.*;
import utils.Utilities;

import java.util.ArrayList;
import java.util.Date;

public class Individual extends Client implements ManageOrders, UserAccount {
    private String fullName;
    private Date birthDate;

    public Individual(String username, String password){
        super(username, password);
    };


    @Override
    public void createAccount() {
        super.createAccount();
        this.fullName = Utilities.leerFrase("Introduce tu nombre completo: ", 8);
        //TODO: VERIFICAR FUNCIONAMIENTO DE LA FECHA
        int day = Utilities.leerInt("Introduce tu día de nacimiento: ", 1, 31);
        int month = Utilities.leerInt("Introduce tu mes de nacimiento: ", 1, 12);
        int year = Utilities.leerInt("Introduce tu año de nacimiento: ", 1900, 2023);

        this.birthDate = new Date(year, month, day);
    }

    @Override
    public void removeAccount(UserList userList) {
        super.removeAccount(userList);
    }


    @Override
    public void modifyAccount() {

    }


    @Override
    public String toString() {
        return "Individual [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + this.getEmail() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ']';
    }
}
