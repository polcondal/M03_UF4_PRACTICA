package utils;
import java.util.Scanner;

/**
 * Clase estática de utilidades
 */
public final class Utilities {
    private static Scanner leer = new Scanner(System.in);

    /**
     * Constructor privado para evitar instanciar la clase
     */
    private Utilities(){};


    /**
     * Método que lee un entero de la consola
     * @param message que mostraremos por consola al usuario para pedir el número
     * @param minValue número mínimo aceptado
     * @param maxValue número máximo aceptado
     * @return valor entero leído
     */
    public static int leerInt(String message, int minValue, int maxValue){
        int numero = 0;
        boolean correcte  = false;

        while(!correcte){
            System.out.println(message);
            if(leer.hasNextInt()){
                numero = leer.nextInt();
                if(numero >= minValue && numero <= maxValue) {
                    correcte = true;
                }else{
                    System.out.printf("El numero ha de ser uno entre %d i %d\n", minValue,maxValue);
                }
            }else{
                System.out.println("Introduce un número");
            }
            leer.nextLine();
        }
        return numero;
    }

    /**
     * Metodo para leer un float
     * @param message mensaje que se muestra al usuario
     * @param min numero minimo aceptado
     * @param max numero maximo aceptado
     * @return valor float leido
     */
    public static float leerFloat(String message, float min, float max) {
        float valor = 0;
        boolean valorCorrecto = false;

        do {
            System.out.println(message);
            valorCorrecto = leer.hasNextFloat();
            if (valorCorrecto) {
                valor = leer.nextFloat();
                leer.nextLine();
                if (valor < min || valor > max){
                    System.out.println("Opción no válida!");
                    valorCorrecto = false;
                }
            } else {
                leer.nextLine();
            }
        }while(valorCorrecto == false);

        return valor;
    }

    /**
     * Método para leer una frase con espacios SIN minimo de caracteres
     * @param message mensaje que se muestra al usuario
     * @return frase leida
     */
    public static String leerFrase(String message){
        System.out.println(message);
        return leer.nextLine();
    }

    /**
     * Método para leer una frase con espacios CON minimo de caracteres
     * @param message mensaje que se muestra al usuario
     * @return frase leida
     */
    public static String leerFrase(String message, int minChars){
        System.out.println(message);
        String frase = leer.nextLine();
        while (frase.length() < minChars){
            System.out.println("Escribe mínimo " + minChars + " caracteres");
            frase = leer.nextLine();
        }
        return  frase;
    }

    /**
     * Método para leer una palabra sin espacios SIN minimo de caracteres
     * @param message mensaje que se muestra al usuario
     * @return palabra leida
     */
    public static String leerPalabra(String message){
        String paraula;
        System.out.println(message);
        paraula = leer.next();
        leer.nextLine();

        return paraula;
    }

    /**
     * Método para leer una palabra sin espacios CON minimo de caracteres
     * @param message mensaje que se muestra al usuario
     * @param minChars minimo de caracteres que debe tener la palabra
     * @return palabra leida
     */
    public static String leerPalabra(String message, int minChars){
        String paraula;
        do {
            System.out.println(message);
            paraula = leer.next();
            leer.nextLine();
            if (paraula.length() < minChars)
                System.out.println("Escribe mínimo " + minChars + " carácteres");
        } while (paraula.length() < minChars);

        return paraula;
    }

    public static String leerMail(String message){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String mail;
        do {
            System.out.println(message);
            mail = leer.next();
            leer.nextLine();
            if (!mail.matches(regex))
                System.out.println("Escribe un mail válido");
        } while (!mail.matches(regex));
        return mail;
    }

}
