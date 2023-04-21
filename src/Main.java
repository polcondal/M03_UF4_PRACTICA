import models.*;
import utils.Utilities;


public class Main {

    public static void main(String[] args) {
        entryMenu();
    }

    private static void entryMenu() {
        byte selection = 0;
        User user = null;

        while (selection != 3) {
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = (byte)Utilities.leerInt("Dispones de cuenta?: \n" +
                            " 1. Sí, Log In  \n" +
                            " 2. No, Sign Up \n" +
                    " 3. Salir \n",
                    1, 3);
            switch (selection) {
                case 1:
                    System.out.println("---------- Menu de Log In ----------");


                    do {
                        String username = Utilities.leerPalabra("Introduce tu nombre de usuario: ");
                        user = UserList.getUserByUsername(username);
                        if (user == null) {
                            System.out.println("El usuario introducido no existe, vuelve a introducirlo");
                        }
                    } while (user == null);

                    String password;
                    do {
                        password = Utilities.leerPalabra("Introduce tu contraseña: ");
                        if (!UserList.isPasswordCorrect(password, user)) {
                            System.out.println("La contraseña introducida no es correcta, vuelve a introducirla");
                        }
                    } while (!UserList.isPasswordCorrect(password, user));

                    // TODO: IMPLEMENTAR MENUS AFTER LOGIN
                    System.out.println("Logeado correctamente");
                    loadUserMenu(user);
                    break;

                case 2:
                    System.out.println("Ya existen " + UserList.countUsers() + " usuarios registrados, a qué esperas?...");
                    System.out.println("---------- Menú de registro ----------");
                    signUpSubMenu(user);
                    break;

                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    break;
            }
        }
    }

    private static void signUpSubMenu(User newUser) {
        String username;
        do {
            username = Utilities.leerPalabra("Introduce tu nombre de usuario: ");
            newUser = UserList.getUserByUsername(username);
            if (newUser != null) {
                System.out.println("El usuario introducido ya existe, vuelve a introducirlo");
            }
        } while (newUser != null);

        String password1;
        String password2;
        do {
            password1 = Utilities.leerPalabra("Introduce tu contraseña: ");
            password2 = Utilities.leerPalabra("Repite tu contraseña: ");
            if (!password2.equals(password1)) {
                System.out.println("Las dos contraseñas introducidas tienen que ser iguales, vuelve a repetir");
            }
        } while (!password2.equals(password1));

        int userType = Utilities.leerInt("Que tipo de usuario eres? \n 1. Individual \n 2. Empresa \n 3. Proveedor",
                1, 3);

        // inicializamos el usuario genérico según el tipo de usuario que sea

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
                //el cif se le pide al instante de crear cuenta ya que no se puede modificar
                final String CIF = Utilities.leerPalabra("Introduce tu CIF: \n" +
                        "ADVERTENCIA: EL CIF NO SE PUEDE MODIFICAR DESPUES DE CREAR LA CUENTA", 9);
                newUser = new Enterprise(username, password1, CIF);
                ((Enterprise)newUser).createAccount();
                break;
            // proveedor
            case 3:
                //TODO: TEST
                newUser = new Supplier(username, password1);
                ((Supplier)newUser).createAccount();
                break;
            default:
                break;
        }
        addUserToList(newUser);
        System.out.println("Felicidades!!! " + newUser.getUsername()+ ", ya formas parte de nuestra familia como " + newUser.getClass().getSimpleName() + "!");

        System.out.println("\n Quieres utilizar la cuenta que acabas de crear? \n 1. Sí \n 2. No");
        int selection = Utilities.leerInt("Introduce una opción: ", 1, 2);
        if (selection == 1) {
            loadUserMenu(newUser);
        }
    }

    // TODO: FALTAN FUNCIONES A APLICAR
    private static void individualMenu() {
        byte selection = 0;

        while (selection != 1) {
            selection = (byte) Utilities.leerInt(
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
    private static void businessMenu() {
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

    private static void supplierMenu() {
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

    private static void loadUserMenu(User user){
        switch (user.getClass().getSimpleName()){
            case "Individual":
                ((Individual)user).userMenu();
                break;
            case "Enterprise":
                ((Enterprise)user).userMenu();
                break;
            case "Supplier":
                ((Supplier)user).userMenu();
                break;
        }
    }

    private static void addUserToList(User user) {
        System.out.println("Añadiendo usuario "+ user.toString() +  " a la base de datos...");
        UserList.addUser(user);
    }
}