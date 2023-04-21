package models;

import java.time.LocalDate;
import interfaces.*;
import utils.Utilities;
import models.UserList;


public class Individual extends Client implements UserAccount {
    private String fullName;
    private LocalDate birthDate;

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

        this.birthDate = LocalDate.of(year, month, day);
    }


    public void userMenu(){
            System.out.println("Bienvenido al menú de Individual: " + this.getUsername() + "\n" +
                    "1. Ver datos de la cuenta" + "\n" +
                    "2. Modificar datos de la cuenta" + "\n" +
                    "3. Ver pedidos" + "\n" +
                    "4. Eliminar cuenta" + "\n" +
                    "5. Salir");
            int option = Utilities.leerInt("Introduce una opción: ", 1, 4);
            switch (option) {
                case 1:
                    System.out.println(this.toString());
                    break;
                case 2:
                    this.modifyAccount();
                    break;
                case 3:
                    this.showOrders();
                    break;
                case 4:
                    this.removeAccount();
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

    }

    @Override
    public void modifyAccount() {
        System.out.println("¿Qué quieres modificar de tu cuenta de Individual?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre completo" + "\n" +
                "4. Fecha de nacimiento" + "\n" +
                "5. Email" + "\n" +
                "6. Dirección" + "\n" +
                "7. Teléfono" + "\n" +
                "8. Salir");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 8);
        switch (option) {
            case 1:
                this.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                break;
            case 2:
                this.tryChangePassword();
                break;
            case 3:
                this.fullName = Utilities.leerFrase("Introduce el nuevo nombre completo: ", 8);
                break;
            case 4:
                int day = Utilities.leerInt("Introduce tu día de nacimiento: ", 1, 31);
                int month = Utilities.leerInt("Introduce tu mes de nacimiento: ", 1, 12);
                int year = Utilities.leerInt("Introduce tu año de nacimiento: ", 1900, 2023);
                this.birthDate = LocalDate.of(year, month, day);
                break;
            case 5:
                boolean emailExists = true;
                do {
                    this.setEmail(Utilities.leerFrase("Introduce el nuevo email: ", 8));
                    if (UserList.doesUserExist(this.getUsername(), this.getEmail())) {
                        System.out.println("El email ya existe, introduce otro.");
                    } else {
                        emailExists = false;
                    }
                } while (emailExists);
                break;
            case 6:
                this.setAddress(Utilities.leerFrase("Introduce la nueva dirección: ", 8));
                break;
            case 7:
                this.setPhoneNumber(Utilities.leerInt("Introduce el nuevo teléfono: ", 100000000, 999999999));
                break;
            case 8:
                System.out.println("Saliendo de la sesión...");
                break;
        }
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
