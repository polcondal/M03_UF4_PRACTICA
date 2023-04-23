package models;

import interfaces.UserAccount;

import java.util.ArrayList;
import utils.Utilities;


public class Supplier extends User implements UserAccount {
    private String supplierName;
    private ArrayList<Shop> supplierShops = new ArrayList<Shop>();

    //Constructor directo defaultData
    public Supplier(String userName, String loginPassword, String supplierName, ArrayList<Shop> supplierShops) {
        super(userName, loginPassword);
        this.supplierName = supplierName;
    }

    public Supplier(String userName, String loginPassword) {
        super(userName, loginPassword);
    }

    @Override
    public void createAccount() {
        this.supplierName = Utilities.leerFrase("Introduce el nombre de proveedor: ", 3);
    }

    @Override
    public void modifyAccount() {
        System.out.println("¿Qué quieres modificar de tu cuenta de Supplier?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre de la empresa" + "\n" +
                "4. Volver");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 7);
        switch (option) {
            case 1:
                this.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                System.out.println("Nombre de usuario cambiado correctamente a " + this.getUsername());
                break;
            case 2:
                this.ChangePassword();
                System.out.println("Contraseña cambiada correctamente");
                break;
            case 3:
                this.supplierName = Utilities.leerFrase("Introduce el nuevo nombre de la empresa: ", 8);
                System.out.println("Nombre de la empresa cambiado correctamente a " + this.supplierName);
                break;
            case 4:
                System.out.println("Volviendo...");
                break;
        }
    }

    @Override
    public String toString() {
        return "Supplier [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ']';
    }

    public void userMenu() {
        int opcio = Utilities.leerInt("BEINVENIDE AL MENÚ SUPPLIER " + this.supplierName +
                        "\n Elige una opción: " + "\n" +
                        " 1. Menú de Tiendas" + "\n" +
                        " 2. Modificar Cuenta " + "\n" +
                        " 3. Eliminar Cuenta" + "\n" +
                        " 4. Log Out",
                1, 4);

        switch (opcio) {
            case 1:
                System.out.println("Menú de Tiendas");
                shopMenu();
                break;
            case 2:
                this.modifyAccount();
                break;
            case 3:
                boolean succesful = this.tryRemoveAccount();
                if (succesful)
                { System.out.println("Cuenta "+ this.getUsername() +" eliminada correctamente");
                    return; } else {
                    System.out.println("No se ha eliminado la cuenta");
                }
                break;
            case 4:
                System.out.println("Saliendo de la sesión...");
                return;

        }
        this.userMenu();
    }

    private void shopMenu() {
        boolean salir = false;
        int opcio = Utilities.leerInt("BEINVENIDE AL MENÚ DE TIENDAS, " + this.supplierName + "\n" +
                "Actualmente hay " + supplierShops.size() + " tiendas a tu nombre \n" +
                        " \n Elige una opción: " + "\n" +
                        " 1. Añadir Tienda " + "\n" +
                        " 2. Eliminar Tienda" + "\n" +
                        " 3. Gestionar Tienda" + "\n" +
                        " 4. Listar Tiendas" + "\n" +
                        " 5. Volver al menú principal",
                1, 5);
        Shop shop = null;
        switch (opcio) {
            case 1:
                System.out.println("Añadir Tienda");
                String shopName = Utilities.leerPalabra("Introduce el nombre de la tienda: ", 3);

                this.supplierShops.add(new Shop(shopName));
                shop = this.supplierShops.get(this.supplierShops.size() - 1);
                System.out.println("Tienda " + shop.getShopName() + " añadida correctamente");
                break;
            case 2:
                if (this.supplierShops.size() == 0) {
                    System.out.println("No hay tiendas que eliminar, crea una antes de eliminarla");
                    break;
                } else {
                    System.out.println("Eliminar Tienda");
                    this.listarTiendas();
                    this.supplierShops.remove(Utilities.leerInt("Introduce el número de la tienda que quieres eliminar: ", 0, supplierShops.size() - 1));
                    salir = true;
                }

                break;
            case 3:
                if (this.supplierShops.size() == 0) {
                    System.out.println("No hay tiendas que gestionar, crea una antes de gestionarla");
                    break;
                } else {
                    this.listarTiendas();
                }
                shop = this.supplierShops.get(Utilities.leerInt("Introduce el número de la tienda que quieres modificar: ", 0, supplierShops.size() - 1));
                shop.shopSubMenu();
                break;
            case 4:
                System.out.println("Listar Tiendas");
                this.listarTiendas();
                break;
            case 5:
                System.out.println("Volver al menú de Supplier");
                return;
        }
        if (!salir){
            this.shopMenu();

        }
    }


    public void addShop(Shop shop) {
        this.supplierShops.add(shop);
    }

    private void listarTiendas() {
        int counter = 0;
        for (Shop shop : this.supplierShops) {
            {
                counter++;
                System.out.println(counter++ + ". " + shop.toString());

            }
        }

    }

}
