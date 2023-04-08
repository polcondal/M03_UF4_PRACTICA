import java.util.Scanner;

import models.*;
import utils.Utilities;

public class Main {

    public static UserList userList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        userList = new UserList();
        entryMenu(scanner);
    }

    private static void entryMenu(Scanner scanner) {
        byte selection = 0;

        while (selection != 1) {
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = (byte)Utilities.leerInt("Dispones de cuenta?: \n" +
                            " 1. Sí, Log In  \n" +
                            " 2. No, Sign Up \n" +
                    " 3. Salir \n",
                    1, 3);
            switch (selection) {
                case 1:
                    System.out.println("---------- Menu de Log In ----------");
                    String username;
                    boolean userExists = false;
                    do {
                        username = Utilities.leerPalabra("Introduce tu nombre de usuario: ");
                        if (!userExists) {
                            System.out.println("El usuario introducido no existe, vuelve a introducirlo");
                        }
                    } while (!userList.doesUserExist(username));

                    String password = Utilities.leerPalabra("Introduce tu contraseña: ");
                    // TODO: DETECTAR SI ES UN MAIL O NO
                    // TODO: MIRAR SI EXISTE EL USUARIO, EN CASO QUE SI Y TENGA BIEN LA CONTRASEÑA
                    // PASAR AL MENU QUE LE PERTOCA SEGUN SU TIPO DE USER

                    individualMenu(scanner); // TEST
                    break;

                case 2:
                    System.out.println("Ya existen " + userList.countUsers() + " usuarios registrados, a qué esperas?...");
                    System.out.println("---------- Menú de registro ----------");
                    signUpSubMenu();
                    break;

                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    selection = 0;
                    break;
            }
        }
    }

    private static void signUpSubMenu() {
        String username;

        boolean userExists = false;
        do {
            username = Utilities.leerPalabra("Introduce tu nombre de usuario: ");
            userExists =  userList.doesUserExist(username);
            if (userExists) {
                System.out.println("El usuario introducido ya existe, vuelve a introducirlo");
            }
        } while (userExists);

        String password1 = "";
        String password2 = "";
        do {
            password1 = Utilities.leerPalabra("Introduce tu contraseña: ");
            password2 = Utilities.leerPalabra("Repite tu contraseña: ");
            if (!password2.equals(password1)) {
                System.out.println("Las dos contraseñas introducidas tienen que ser iguales, vuelve a repetir");
            }
        } while (!password2.equals(password1));

        int userType = Utilities.leerInt("Que tipo de usuario eres? \n 1. Individual \n 2. Empresa \n 3. Proveedor",
                1, 3);

        // declaramos el usuario genérico y lo inicializamos según el tipo de usuario
        User newUser;
        switch (userType) {
            // individual
            case 1:
                //TODO: TEST
                newUser = new Individual(username, password1);
                ((Individual)newUser).createAccount();
                break;
            // empresa
            case 2:
                //TODO: TEST
                // el cif se le pide al instante de crear cuenta ya que no se puede modificar
                final String CIF = Utilities.leerPalabra("Introduce tu CIF: \n" +
                        "ADVERTENCIA: EL CIF NO SE PUEDE MODIFICAR DESPUES DE CREAR LA CUENTA", 9);
                newUser = new Enterprise(username, password1, CIF);
                ((Enterprise)newUser).createAccount();
                break;
            // proveedor
            case 3:
                //TODO: IMPLEMENT
                newUser = new Supplier("papaprpaarparpa", "contra123");
                break;
            default:
                newUser = null;
                break;
        }
        addUserToList(newUser);
        System.out.println("Felicidades!!! " + newUser.getUsername()+ ", ya formas parte de nuestra familia!");
    }

    // TODO: FALTAN FUNCIONES A APLICAR
    private static void individualMenu(Scanner scanner) {
        byte selection = 0;

        while (selection != 1) {
            selection = (byte)Utilities.leerInt(
                    "Elige una de las siguientes opciones: \n 1. Salir de la sesion \n 2. Listar productos \n 3. Comprar producto \n 4. Modificar usuario",
                    1, 5);
            switch (selection) {
                case 1:
                    System.out.println("Saliendo de la sesión...");
                    break;
                case 2:
                    System.out.println("Listando productos");
                    break;
                case 3:
                    System.out.println("Comprando producto");
                    break;
                case 4:
                    System.out.println("Modificando usuario");
                    break;
            }
        }
    }

    // TODO: MODIFICAR INPUTS Y ACCIONES DE ESTOS MENUS, PRIMERO QUE FUNCIONE EN
    // INDIVIDUAL
    private static void businessMenu(Scanner scanner) {
        byte selection = 0;

        while (selection != 1) {
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = (byte)Utilities.leerInt(
                    "Elige una de las siguientes opciones: \n 1. Log in cliente \n 2. Log in empresa \n 3. Log in vendedor",
                    1, 5);
            switch (selection) {
                case 1:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                case 2:
                    System.out.println("Log In");
                    break;
                case 3:
                    System.out.println("Sign Up");
                    break;
            }
        }
    }

    private static void supplierMenu(Scanner scanner) {
        int selection = Integer.MAX_VALUE;

        while (selection != 1) {
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = Utilities.leerInt(
                    "Elige una de las siguientes opciones: \n 1. Log in cliente \n 2. Log in empresa \n 3. Log in vendedor",
                    1, 5);
            switch (selection) {
                case 1:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                case 2:
                    System.out.println("Log In");
                    break;
                case 3:
                    System.out.println("Sign Up");
                    break;
            }
        }
    }

    private static void addUserToList(User user) {
        System.out.println("Añadiendo usuario "+ user +  " a la base de datos...");
        userList.addUser(user);
    }
}