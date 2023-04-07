import java.util.Scanner;
import utils.Utilities;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginMenu(scanner);
    }

    private static void LoginMenu(Scanner scanner){
        int selection = Integer.MAX_VALUE;

        while(selection != 1){
            System.out.println("・・・・・・・・・・・・・・❥✿ BIENVENIDE ❥✿・・・・・・・・・・・・・・");
            selection = Utilities.llegirInt("Elige una de las siguientes opciones: \n 1. Salir de la aplicación \n 2. Log In \n 3. Sign Up", 1, 3);
            switch (selection){
                case 1: System.out.println("Saliendo de la aplicación...");
                    break;

                case 2: System.out.println("Log In");
                    String email = Utilities.llegirParaula("Introduce tu email: ");
                    String password = Utilities.llegirParaula("Introduce tu contraseña: ");
                    //TODO: COMPROVAR A TRAVÉS DE RESEX QUE ES UN MAIL
                    //TODO: COMPROVAR EXISTENCIA D'USUARI SEGONS ELS PARAMETRES PASSATS....
                    IndividualMenu(scanner);
                    break;

                case 3: System.out.println("Sign Up");
                    break;

                default: selection = Integer.MAX_VALUE; break;
            }
        }
    }

    private static void IndividualMenu(Scanner scanner){
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

    private static void BusinessMenu(Scanner scanner){
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

    private static void SupplierMenu(Scanner scanner){
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