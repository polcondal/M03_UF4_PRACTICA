import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import models.*;
import utils.Utilities;

public class Main {

    public static Shop shop;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        shop = new Shop();
        entryMenu(scanner);
    }

    private static void entryMenu(Scanner scanner){
        int selection = Integer.MAX_VALUE;

        while(selection != 1){
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = Utilities.llegirInt("Elige una de las siguientes opciones: \n 1. Salir de la aplicación \n 2. Log In \n 3. Sign Up", 1, 3);
            switch (selection){
                case 1: System.out.println("Saliendo de la aplicación...");
                    break;

                case 2: System.out.println("Log In");
                    String username = Utilities.llegirParaula("Introduce tu nombre de usuario: ");
                    String password = Utilities.llegirParaula("Introduce tu contraseña: ");
                    //TODO: DETECTAR SI ES UN MAIL O NO
                    //TODO: MIRAR SI EXISTE EL USUARIO, EN CASO QUE SI Y TENGA BIEN LA CONTRASEÑA PASAR AL MENU QUE LE PERTOCA SEGUN SU TIPO DE USER

                    individualMenu(scanner); // TEST
                    break;

                case 3: System.out.println("Sign Up");
                    signUpSubMenu();
                    break;

                default: selection = Integer.MAX_VALUE; break;
            }
        }
    }

    private static void signUpSubMenu(){
        String username1 = Utilities.llegirParaula("Introduce tu nombre de usuario: ");
        String password1 = Utilities.llegirParaula("Introduce tu contraseña: ");
        String password2 = Utilities.llegirParaula("Repite tu contraseña: ");

        while (!password2.equals(password1)){
            System.out.println("Las dos contraseñas introducidas tienen que ser iguales, vuelve a repetir");
            password1 = Utilities.llegirParaula("Introduce tu contraseña: ");
            password2 = Utilities.llegirParaula("Repite tu contraseña: ");
        }

        int userType = Utilities.llegirInt("Que tipo de usuario eres? \n 1. Individual \n 2. Empresa \n 3. Proveedor", 1,3);
        User newUser;
        switch (userType){
            // TODO: DATOS TEMPORALES, pedirlos antes por pantalla
            // TODO: MIRAR SI REALMENTE ES UN MAIL Y QUE NO EXISTA YA EN LA LISTA DE USUARIOS
            case 1: newUser = new Individual(666666666,"pepe@pepito.com", "papaprpaarparpa","pepe", "contra123", new ArrayList<Order>() , "ppepe pepepe ep", new Date(2002,10,29)); break;
            case 2: newUser = new Enterprise(666666666,"pepe@pepito.com", "papaprpaarparpa","pepe", "contra123", new ArrayList<Order>() , "4213321312d","pepe palotes"); break;
            case 3: newUser = new Supplier("papaprpaarparpa","contra123"); break;
            default: newUser = null; break;
        }
        shop.addUser(newUser);
        System.out.println("Felicidades, ya formas parte de nuestra familia!");
    }


    //TODO: FALTAN FUNCIONES A APLICAR
    private static void individualMenu(Scanner scanner){
        int selection = Integer.MAX_VALUE;

        while(selection != 1){
            selection = Utilities.llegirInt("Elige una de las siguientes opciones: \n 1. Salir de la sesion \n 2. Listar productos \n 3. Comprar producto \n 4. Modificar usuario", 1, 5);
            switch (selection){
                case 1: System.out.println("Saliendo de la sesión..."); break;
                case 2: System.out.println("Listando productos"); break;
                case 3: System.out.println("Comprando producto"); break;
                case 4: System.out.println("Modificando usuario"); break;
            }
        }
    }

    //TODO: MODIFICAR INPUTS Y ACCIONES DE ESTOS MENUS, PRIMERO QUE FUNCIONE EN INDIVIDUAL
    private static void businessMenu(Scanner scanner){
        int selection = Integer.MAX_VALUE;

        while(selection != 1){
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = Utilities.llegirInt("Elige una de las siguientes opciones: \n 1. Log in cliente \n 2. Log in empresa \n 3. Log in vendedor", 1, 5);
            switch (selection){
                case 1: System.out.println("Saliendo de la aplicación..."); break;
                case 2: System.out.println("Log In"); break;
                case 3: System.out.println("Sign Up"); break;
            }
        }
    }

    private static void supplierMenu(Scanner scanner){
        int selection = Integer.MAX_VALUE;

        while(selection != 1){
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = Utilities.llegirInt("Elige una de las siguientes opciones: \n 1. Log in cliente \n 2. Log in empresa \n 3. Log in vendedor", 1, 5);
            switch (selection){
                case 1: System.out.println("Saliendo de la aplicación..."); break;
                case 2: System.out.println("Log In"); break;
                case 3: System.out.println("Sign Up"); break;
            }
        }
    }
}