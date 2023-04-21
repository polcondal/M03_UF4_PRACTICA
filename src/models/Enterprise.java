package models;

import interfaces.*;
import utils.Utilities;

import java.util.ArrayList;

public class Enterprise extends Client implements UserAccount{
    final private String cif;
    private String enterpriseName;

    public Enterprise(String username, String password, String cif, String enterpriseName, int phoneNumber, String email, String address, ArrayList<Order> enterpriseOrders){
        super(username, password, enterpriseOrders);
        this.cif = cif;
        this.enterpriseName = enterpriseName;
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setAddress(address);

    };
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
    public void modifyAccount() {
        System.out.println("¿Qué quieres modificar de tu cuenta de Enterprise?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre de la empresa" + "\n" +
                "4. Email" + "\n" +
                "5. Dirección" + "\n" +
                "6. Teléfono" + "\n" +
                "7. Salir");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 7);
        switch (option) {
            case 1:
                this.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                break;
            case 2:
                this.ChangePassword();
                break;
            case 3:
                this.enterpriseName = Utilities.leerFrase("Introduce el nuevo nombre de la empresa: ", 8);
                break;
            case 4:
                this.setEmail(Utilities.leerFrase("Introduce el nuevo email: ", 8));
                break;
            case 5:
                this.setAddress(Utilities.leerFrase("Introduce la nueva dirección: ", 8));
                break;
            case 6:
                this.setPhoneNumber(Utilities.leerInt("Introduce el nuevo teléfono: ", 100000000, 999999999));
                break;
            case 7:
                System.out.println("Saliendo de la sesión...");
                break;
        }
    }

    public void userMenu() {
        System.out.println("Bienvenido al menú de Empresa " + this.getUsername());
        System.out.println("1. Ver mis datos");
        System.out.println("2. Modificar mis datos");
        System.out.println("3. Eliminar mi cuenta");
        System.out.println("4. Ver mis orders");
        System.out.println("5. Salir");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 4);
        switch (option) {
            case 1:
                System.out.println(this.toString());
                break;
            case 2:
                this.modifyAccount();
                break;
            case 3:
                tryRemoveAccount();
                break;
            case 4:
                this.showOrders();
                break;
            case 5:
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
