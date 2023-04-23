package models;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.Utilities;

public class Individual extends Client {
    private String fullName;
    private LocalDate birthDate;

    public Individual(String username, String password, String fullName, LocalDate birthDate, int phoneNumber, String email, String address, ArrayList<Order> clientOrders){
        super(username, password, clientOrders);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setAddress(address);
        clientOrders = new ArrayList<>();
    };

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
