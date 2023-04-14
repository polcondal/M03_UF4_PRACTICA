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
    public void removeAccount(UserList userList) {
        super.removeAccount(userList);
    }


    @Override
    public void modifyAccount() {

    }

    public void userMenu() {
        System.out.println("Bienvenido al menú de Empresa " + this.getUsername());
        System.out.println("1. Ver mis datos");
        System.out.println("2. Modificar mis datos");
        System.out.println("3. Eliminar mi cuenta");
        System.out.println("4. Salir");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 4);
        switch (option) {
            case 1:
                System.out.println(this.toString());
                break;
            case 2:
                this.modifyAccount();
                break;
            case 3:

                break;
            case 4:
                System.out.println("Saliendo...");
                break;
        }
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
