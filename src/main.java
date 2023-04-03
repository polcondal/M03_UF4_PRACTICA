import java.util.Scanner;

import models.GenericProduct;
import utils.Utilities;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("・・・・・・・・・・・・・・❥✿BIENVENIDE ❥✿・・・・・・・・・・・・・・");
        int resultado = Utilities.llegirInt("Elige una de las siguientes opciones: \n 1. Log in cliente \n 2. Log in empresa \n 3. Log in vendedor", 1, 5);

            switch (resultado) {
                case 1:
                    System.out.println("Menú cliente");
                    break;
                case 2:
                    System.out.println("Menú empresa");
                    break;
                case 3:
                    System.out.println("Menú vendedor");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
    }
}