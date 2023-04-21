package models;
import interfaces.UserAccount;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Utilities;


public class Supplier extends User implements UserAccount {
    private String supplierName;
    private ArrayList<Shop> supplierShops = new ArrayList<Shop>();
    private ArrayList<GenericProduct> supplierProducts = new ArrayList<GenericProduct>();



    // TODO: TODO
    // QUE NO TENGA UNA LISTA DE PRODUCTOS, PERO QUE SEA EL UNICO QUE TENGA PERMISOS PARA AÑADIR PRODUCTOS A LA TIENDA DESDE EL MENU
    public Supplier(String userName, String loginPassword) {
        super(userName, loginPassword);
    }



    @Override
    public void createAccount() {
    //TODO: IMPLEMENTAR
        this.supplierName = Utilities.leerFrase("Introduce el nombre de proveedor: ", 3);
    }


    @Override
    public void modifyAccount() {

    }

    @Override
    public String toString(){
        return "Supplier [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ']';
    }

        public void menuSupplier(User user){
            System.out.println();

            int opcio = Utilities.leerInt("\"BEINVENIDE AL MENÚ SUPPLIER \\n Elige una opción: \" +\n" +
                    "                    \"\\n\\t 1. Listar mis productos \" +\n" +
                    "                    \"\\n\\t 2. Añadir producto nuevo \" +\n" +
                    "                    \"\\n\\t 3. Eliminar producto \" +\n" +
                    "                    \"\\n\\t 4. Listar tiendas\" +\n" +
                    "                    \"\\n\\t 5.  \"", 1, 5);

            switch (opcio){
                case 1:
                    System.out.println("Listar mis productos");
                    break;
                case 2:
                    System.out.println("Añadir producto nuevo");
                    break;
                case 3:
                    System.out.println("Eliminar producto");
                    break;
                case 4:
                    System.out.println("Listar clientes");
                    break;
                case 5:
                    System.out.println("Salir");
                    break;

            }


        }
    public void listarProducto() {
        System.out.println("Listar mis productos");
        for (GenericProduct product : this.supplierProducts) {
              {
                System.out.println(product);

        }
    }

}
}
