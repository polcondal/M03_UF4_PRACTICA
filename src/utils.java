import java.util.Scanner;

public class utils {

    /**
     * LLegeix un valor int per teclat
     * 
     * @param text Text que es mostrarà per pantalla per demanar l'entrada
     * @param min  Valor mínim que pot introduir l'usuari
     * @param max  Valor màxim que pot introduir l'usuari
     * @return Retorna un número enter entre el valor mínim i el valor màxim
     */
    public static int llegirInt(String text, int min, int max) {
        boolean tipusCorrecte = false;
        int num = 0;
        Scanner llegir = new Scanner(System.in);

        do {
            System.out.println(text);
            tipusCorrecte = llegir.hasNextInt(); // hasNext();

            if (!tipusCorrecte) {
                System.out.println("ERROR, Escriu un número");
                tipusCorrecte = false;
            } else {
                num = llegir.nextInt();
                tipusCorrecte = true;
                if (num < min || num > max) {
                    System.out.println("ERROR, Escriu un número de " + min + " a " + max + "!");
                    tipusCorrecte = false;
                }

            }
            llegir.nextLine(); // nextLine();
        } while (!tipusCorrecte);

        return num;
    }

    /**
     * LLegeix un valor boolean per teclat
     * 
     * @param text Text que es mostrarà per pantalla per demanar l'entrada
     * @return Retorna true o false
     */
    public static boolean llegirBool(String text) {
        boolean tipusCorrecte = false, bool = false;
        String inpuString = "";
        Scanner llegir = new Scanner(System.in);

        do {
            System.out.println(text);
            inpuString = llegir.nextLine();

            tipusCorrecte = false;

            if (inpuString == "Si" ||
                    inpuString == "si" ||
                    inpuString == "SI" ||
                    inpuString == "sI" ||
                    inpuString == "S" ||
                    inpuString == "s") {
                tipusCorrecte = true;
                bool = true;

            } else {
                System.out.println("ERROR, Escriu un número de ");
                tipusCorrecte = false;
                bool = false;
            }

            llegir.nextLine(); // nextLine();

        } while (!tipusCorrecte);

        return bool;
    }
}
