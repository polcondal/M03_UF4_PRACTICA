package models;

import interfaces.UserAccount;

import java.util.ArrayList;
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
        System.out.println("¿Qué quieres modificar de tu cuenta de Supplier?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre de la empresa" + "\n" +
                "4. Log Out");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 7);
        switch (option) {
            case 1:
                this.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                break;
            case 2:
                this.tryChangePassword();
                break;
            case 3:
                this.supplierName = Utilities.leerFrase("Introduce el nuevo nombre de la empresa: ", 8);
                break;
            case 4:
                System.out.println("Saliendo de la sesión...");
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
        int opcio = Utilities.leerInt("BEINVENIDE AL MENÚ SUPPLIER \n Elige una opción: " + "\n" +
                " 1. Menú de productos " + "\n" +
                " 2. Menú de Tiendas" + "\n" +
                " 3. Modificar Cuenta " + "\n" +
                " 4. Eliminar Cuenta" + "\n" +
                " 5. Log Out",
                1, 5);

        switch (opcio) {
            case 1:
                System.out.println("Menú de productos");
                this.listarProductos();
                break;
            case 2:
                System.out.println("Menú de Tiendas");
                shopMenu();

                break;
            case 3:
                System.out.println("");
                this.modifyAccount();
                break;
            case 4:
                System.out.println("Eliminar Cuenta");
                this.removeAccount();
                break;
            case 5:
                System.out.println("Saliendo de la sesión...");
                return;

        }
        this.userMenu();
    }

    private void shopMenu() {
        int opcio = Utilities.leerInt("BEINVENIDE AL MENÚ DE TIENDAS \n Elige una opción: " + "\n" +
                " 1. Añadir Tienda " + "\n" +
                " 2. Eliminar Tienda" + "\n" +
                " 3. Modificar Tienda" + "\n" +
                " 4. Listar Tiendas" + "\n" +
                " 5. Volver al menú principal",
                1, 5);
        Shop shop = null;
        switch (opcio) {
            case 1:
                System.out.println("Añadir Tienda");
                String shopName = Utilities.leerPalabra("Introduce el nombre de la tienda: ", 3);

                supplierShops.add(new Shop(shopName));
                shop = supplierShops.get(supplierShops.size() - 1);
                System.out.println("Tienda " + shop.getShopName() + " añadida correctamente");
                break;
            case 2:
                System.out.println("Eliminar Tienda");
                supplierShops.remove(Utilities.leerInt("Introduce el número de la tienda que quieres eliminar: ", 1, supplierShops.size()));
                break;
            case 3:
                System.out.println("Gestionar Tienda");
                shop = supplierShops.get(Utilities.leerInt("Introduce el número de la tienda que quieres modificar: ", 1, supplierShops.size()));
                shop.shopMenu();
                break;
            case 4:
                System.out.println("Listar Tiendas");
                this.listarTiendas();
                break;
            case 5:
                System.out.println("Volver al menú de Supplier");
                return;
        }
        this.shopMenu();
    }


    private void listarProductos() {
        int counter = 0;
        for (GenericProduct product : this.supplierProducts) {
            {
                counter++;
                System.out.println(counter++);
                System.out.println(product);

            }
        }

    }

    private void listarTiendas() {
        int counter = 0;
        for (Shop shop : this.supplierShops) {
            {
                counter++;
                System.out.println(counter++);
                System.out.println(shop);

            }
        }

    }
}
