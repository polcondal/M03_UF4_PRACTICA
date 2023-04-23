import models.*;
import models.enums.*;
import utils.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static Shop shop;

    public static void main(String[] args) {
        shop = new Shop("POL&NAHO's");
        addDefaultData();
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
                    user = loginMenu();
                    break;

                case 2:
                    user = signUpSubMenu();
                    break;

                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    break;
            }
        }
    }

    private static User loginMenu(){
        System.out.println("---------- Menu de Log In ----------");
        User user = null;

        do {
            String username = Utilities.leerPalabra("Introduce tu nombre de usuario: ");
            user = shop.getUserByUsername(username);
            if (username.equals("EXIT")) {
                return null;
            }else if (user == null) {
                System.out.println("El usuario introducido no existe, vuelve a introducirlo o escribe EXIT en caso de querer salir");
            }
        } while (user == null);

        String password;
        do {
            password = Utilities.leerPalabra("Introduce tu contraseña: ");
             if (password.equals("EXIT")) {
                return null;
            }else if (!shop.isPasswordCorrect(password, user)) {
                System.out.println("La contraseña introducida no es correcta, vuelve a introducirla o escribe EXIT en caso de querer salir");
            }
        } while (!shop.isPasswordCorrect(password, user));

        System.out.println("Logeado correctamente");
        loadUserMenu(user);

        return user;
    }

    private static User signUpSubMenu() {
        String username;
        System.out.println("Ya existen " + shop.countUsers() + " usuarios registrados, a qué esperas?...");
        System.out.println("---------- Menú de registro ----------");

        User newUser = null;
        do {
            username = Utilities.leerPalabra("Introduce tu nombre de usuario: ");
            newUser = shop.getUserByUsername(username);
            if (username.equals("EXIT")) {
                return null;
            }else if (newUser != null) {
                System.out.println("El usuario introducido ya existe, vuelve a introducirlo");
            }
        } while (newUser != null);

        String password1;
        String password2;
        do {
            password1 = Utilities.leerPalabra("Introduce tu contraseña: ");
            password2 = Utilities.leerPalabra("Repite tu contraseña: ");
            if (password1.equals("EXIT")) {
                return null;
            }else if (!password2.equals(password1)) {
                System.out.println("Las dos contraseñas introducidas tienen que ser iguales, vuelve a repetir");
            }
        } while (!password2.equals(password1));

        int userType = Utilities.leerInt("Que tipo de usuario eres? \n 1. Individual \n 2. Empresa \n 3. Proveedor",
                1, 3);

        // inicializamos el usuario genérico según el tipo de usuario que sea
        switch (userType) {

            // individual
            case 1:
                String fullName = Utilities.leerFrase("Introduce tu nombre completo: ", 8);
                int day = Utilities.leerInt("Introduce tu día de nacimiento: ", 1, 31);
                int month = Utilities.leerInt("Introduce tu mes de nacimiento: ", 1, 12);
                int year = Utilities.leerInt("Introduce tu año de nacimiento: ", 1900, 2023);

                LocalDate birthDate = LocalDate.of(year, month, day);
                newUser = new Individual(
                        username,
                        password1,
                        fullName,
                        birthDate,
                        Utilities.leerInt("Introduce tu numero de telefono: ", 0 , 999999999),
                        Utilities.leerMail("Introduce tu e-mail: "),
                        Utilities.leerFrase("Intoduce tu dirección: "),
                        new ArrayList<Order>());
                shop.addUser(newUser);
                break;

            // empresa
            case 2:
                //el cif se le pide al instante de crear cuenta ya que no se puede modificar
                final String CIF = Utilities.leerPalabra("Introduce tu CIF: \n" +
                        "ADVERTENCIA: EL CIF NO SE PUEDE MODIFICAR DESPUES DE CREAR LA CUENTA", 9);
                String enterpriseName = Utilities.leerFrase("Introduce el nombre de la empresa: ", 8);

                newUser = new Enterprise(
                        username,
                        password1,
                        CIF,
                        enterpriseName,
                        Utilities.leerInt("Introduce tu numero de telefono: ", 0 , 999999999),
                        Utilities.leerMail("Introduce tu e-mail: "),
                        Utilities.leerFrase("Intoduce tu dirección: "),
                        new ArrayList<Order>());

                shop.addUser(newUser);
                break;

            // proveedor
            case 3:
                String supplierName = Utilities.leerPalabra("Introduce nombre de supplier.");

                newUser = new Supplier(username, password1, supplierName);
                shop.addUser(newUser);
                break;
            default:
                break;
        }
        System.out.println("Felicidades!!! " + newUser.getUsername()+ ", ya formas parte de nuestra familia como " + newUser.getClass().getSimpleName() + "!");

        System.out.println("\n Quieres utilizar la cuenta que acabas de crear? \n 1. Sí \n 2. No");
        int selection = Utilities.leerInt("Introduce una opción: ", 1, 2);
        if (selection == 1) {
            loadUserMenu(newUser);
        }
        return newUser;
    }

    private static void individualMenu(Individual user) {
        int option  = 0;

        while(option!=7){
            System.out.println("Bienvenido al menú de Individual: " + user.getUsername() + "\n" +
                    "1. Ver datos de la cuenta" + "\n" +
                    "2. Modificar datos de la cuenta" + "\n" +
                    "3. Ver pedidos" + "\n" +
                    "4. Eliminar cuenta" + "\n" +
                    "5. Observar productos de la tienda" + "\n" +
                    "6. Comprar producto" + "\n" +
                    "7. Salir");
            option = Utilities.leerInt("Introduce una opción: ", 1, 7);
            switch (option) {
                case 1:
                    System.out.println(user.toString());
                    break;
                case 2:
                    modifyIndividualAccount(user);
                    break;
                case 3:
                    user.showOrders();
                    break;
                case 4:
                    boolean isSure = shop.tryRemoveAccount(user);
                    if(isSure){
                        return;
                    }
                    break;
                case 5:
                    shop.showProductList();
                    break;
                case 6:
                    int productid = Utilities.leerInt("Que productId tiene el producto que quieres comprar? ", 0 ,999999999);
                    int quantity = Utilities.leerInt("Que cantidad quieres del producto? ", 1 ,999999999);

                    float presupuesto = shop.CalculateBill(productid, false, quantity);
                    if(presupuesto == 0.0f){
                        System.out.println("NO SE HA ENCONTRADO EL PRODUCTO QUE DESEAS");
                        break;
                    }
                    boolean keepGoing = Utilities.leerBoolean("El presupuesto por esta acción sera de "+ presupuesto +"€ ¿Estás seguro de que quieres eliminar tu cuenta?");
                    if (keepGoing) {
                        user.addOrder(shop.BuyProduct(productid, false, quantity));
                    }else{
                        System.out.printf("Se ha cancelado la compra!");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }

    public static void modifyIndividualAccount(Individual user) {
        System.out.println("¿Qué quieres modificar de tu cuenta de Individual?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre completo" + "\n" +
                "4. Fecha de nacimiento" + "\n" +
                "5. Email" + "\n" +
                "6. Dirección" + "\n" +
                "7. Teléfono" + "\n" +
                "8. Salir");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 8);
        switch (option) {
            case 1:
                user.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                break;
            case 2:
                user.ChangePassword();
                break;
            case 3:
                user.setFullName(Utilities.leerFrase("Introduce el nuevo nombre completo: ", 8));
                break;
            case 4:
                int day = Utilities.leerInt("Introduce tu día de nacimiento: ", 1, 31);
                int month = Utilities.leerInt("Introduce tu mes de nacimiento: ", 1, 12);
                int year = Utilities.leerInt("Introduce tu año de nacimiento: ", 1900, 2023);
                user.setBirthDate(LocalDate.of(year, month, day));
                break;
            case 5:
                boolean emailExists = true;
                do {
                    user.setEmail(Utilities.leerFrase("Introduce el nuevo email: ", 8));
                    if (shop.doesUserExist(user.getUsername(), user.getEmail())) {
                        System.out.println("El email ya existe, introduce otro.");
                    } else {
                        emailExists = false;
                    }
                } while (emailExists);
                break;
            case 6:
                user.setAddress(Utilities.leerFrase("Introduce la nueva dirección: ", 8));
                break;
            case 7:
                user.setPhoneNumber(Utilities.leerInt("Introduce el nuevo teléfono: ", 100000000, 999999999));
                break;
            case 8:
                System.out.println("Saliendo de la sesión...");
                break;
        }
    }

    private static void enterpriseMenu(Enterprise user) {
        int option  = 0;

        while(option!=7) {
            System.out.println("Bienvenido al menú de Empresa " + user.getUsername());
            System.out.println("1. Ver mis datos");
            System.out.println("2. Modificar mis datos");
            System.out.println("3. Eliminar mi cuenta");
            System.out.println("4. Ver mis orders");
            System.out.println("5. Observar productos de la tienda");
            System.out.println("6. Comprar producto");
            System.out.println("7. Salir");
            option = Utilities.leerInt("Introduce una opción: ", 1, 7);
            switch (option) {
                case 1:
                    System.out.println(user.toString());
                    break;
                case 2:
                    modifyEnterpriseAccount(user);
                    break;
                case 3:
                    boolean isSure = shop.tryRemoveAccount(user);
                    if(isSure){
                        return;
                    }
                    break;
                case 4:
                    user.showOrders();
                    break;
                case 5:
                    shop.showProductList();
                    break;
                case 6:
                    int productid = Utilities.leerInt("Que productId tiene el producto que quieres comprar? ", 0 ,999999999);
                    int quantity = Utilities.leerInt("Que cantidad quieres del producto? ", 1 ,999999999);

                    float presupuesto = shop.CalculateBill(productid, true, quantity);
                    if(presupuesto == 0.0f){
                        System.out.println("NO SE HA ENCONTRADO EL PRODUCTO QUE DESEAS");
                        break;
                    }
                    boolean keepGoing = Utilities.leerBoolean("El presupuesto por esta acción sera de "+ presupuesto +"€ ¿Estás seguro de que quieres eliminar tu cuenta?");
                    if (keepGoing) {
                        user.addOrder(shop.BuyProduct(productid, true, quantity));
                    }else{
                        System.out.printf("Se ha cancelado la compra!");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }

    public static void modifyEnterpriseAccount(Enterprise enterprise) {
        System.out.println("¿Qué quieres modificar de tu cuenta de Enterprise?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre de la empresa" + "\n" +
                "4. Email" + "\n" +
                "5. Dirección" + "\n" +
                "6. Teléfono" + "\n" +
                "7. Salir");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 7);
        switch (option) {
            case 1:
                enterprise.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                break;
            case 2:
                enterprise.ChangePassword();
                break;
            case 3:
                enterprise.setEnterpriseName(Utilities.leerFrase("Introduce el nuevo nombre de la empresa: ", 8));
                break;
            case 4:
                enterprise.setEmail(Utilities.leerFrase("Introduce el nuevo email: ", 8));
                break;
            case 5:
                enterprise.setAddress(Utilities.leerFrase("Introduce la nueva dirección: ", 8));
                break;
            case 6:
                enterprise.setPhoneNumber(Utilities.leerInt("Introduce el nuevo teléfono: ", 100000000, 999999999));
                break;
            case 7:
                System.out.println("Saliendo de la sesión...");
                break;
        }
    }


    private static void supplierMenu(Supplier user) {
        int option  = 0;

        while(option!=5){
            int opcio = Utilities.leerInt("BEINVENIDE AL MENÚ SUPPLIER " + user.getSupplierName() +
                            "\n Elige una opción: " + "\n" +
                            " 1. Añadir producto en Tienda" + "\n" +
                            " 2. Eliminar producto de Tienda" + "\n" +
                            " 3. Modificar Cuenta " + "\n" +
                            " 4. Eliminar Cuenta" + "\n" +
                            " 5. Log Out",
                    1, 5);

            switch (opcio) {
                case 1:
                    System.out.println("Añadiendo producto en Tienda");
                    String productType = "";
                    while(productType!= "Ropa"|| productType!= "Alimento" || productType!= "Tecnologia"){
                        productType = Utilities.leerPalabra("Que tipo de producto quieres añadir? \n -Ropa \n -Alimento \n -Tecnologia");
                    }

                    if(productType.equals("Ropa")){

                        GenericProduct product = new Clothing(
                                user.getSupplierName(),
                                Utilities.leerFrase("Introduce como se llama el producto: "),
                                Utilities.leerFloat("Introduce el precio del producto: ", 0.00f, 100000000000000f),
                                Utilities.leerInt("Introduce cuantas unidades quieres añaddir de este producto", 1, 100000000),
                                Utilities.leerFrase("Introduce la marca del producto: "),
                                chooseClothingMaterials(),
                                chooseClothingSize()
                        );

                        shop.addProduct(product);

                    }else if(productType.equals("Alimento")){
                        GenericProduct product = new Edible(
                                user.getSupplierName(),
                                Utilities.leerFrase("Introduce como se llama el producto: "),
                                Utilities.leerFloat("Introduce el precio del producto: ", 0.00f, 100000000000000f),
                                Utilities.leerInt("Introduce cuantas unidades quieres añaddir de este producto", 1, 100000000),
                                Utilities.leerFrase("Introduce la marca del producto: "),
                                Utilities.leerFrase("Describe los porcentajes de lo que contenga el alimento: ")
                        );
                        shop.addProduct(product);

                    }else if(productType.equals("Tecnologia")){
                        GenericProduct product = new Technology(
                                user.getSupplierName(),
                                Utilities.leerFrase("Introduce como se llama el producto: "),
                                Utilities.leerFloat("Introduce el precio del producto: ", 0.00f, 100000000000000f),
                                Utilities.leerInt("Introduce cuantas unidades quieres añaddir de este producto", 1, 100000000),
                                Utilities.leerFrase("Introduce la marca del producto: "),
                                Utilities.leerFrase("Introduce el codigo de serie del modelo: ")
                        );
                        shop.addProduct(product);

                    }
                    break;
                case 2:
                    System.out.println("Eliminando producto de Tienda");
                    boolean succes = shop.tryRemoveProduct(user, Utilities.leerFrase("Introduce el nombre del producto a eliminar: "));
                    if(succes){
                        System.out.println("Se ha eliminado el producto de nuestra base de datos");
                    }else{
                        System.out.println("No se ha encontrado el producto en nuestra base de datos");
                    }
                    break;
                case 3:
                    modifySupplierAccount(user);
                    break;
                case 4:
                    boolean isSure = shop.tryRemoveAccount(user);
                    if(isSure){
                        return;
                    }
                    break;
                case 5:
                    System.out.println("Saliendo de la sesión...");
                    break;
            }
        }
    }

    public static void modifySupplierAccount(Supplier supplier) {
        System.out.println("¿Qué quieres modificar de tu cuenta de Supplier?" + "\n" +
                "1. Nombre de usuario" + "\n" +
                "2. Contraseña" + "\n" +
                "3. Nombre de la empresa" + "\n" +
                "4. Volver");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 7);
        switch (option) {
            case 1:
                supplier.setUsername(Utilities.leerFrase("Introduce el nuevo nombre de usuario: ", 3));
                System.out.println("Nombre de usuario cambiado correctamente a " + supplier.getUsername());
                break;
            case 2:
                supplier.ChangePassword();
                System.out.println("Contraseña cambiada correctamente");
                break;
            case 3:
                supplier.setSupplierName(Utilities.leerFrase("Introduce el nuevo nombre de la empresa: ", 4));
                System.out.println("Nombre de la empresa cambiado correctamente a " + supplier.getSupplierName());
                break;
            case 4:
                System.out.println("Volviendo...");
                break;
        }
    }

    private static ClothingMaterials chooseClothingMaterials(){
        System.out.println("De que material esta principalmente hecha esta pieza de ropa? ");
        for (ClothingMaterials materials : ClothingMaterials.values()) {
            System.out.println("- " + materials.name());
        }
        Scanner scanner = new Scanner(System.in);
        ClothingMaterials seleccion = null;
        while (seleccion == null) {
            try {
                String input = scanner.nextLine().toUpperCase();
                seleccion = ClothingMaterials.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Selección inválida. Intente de nuevo.");
            }
        }
        return seleccion;
    }
    private static ClothingSizes chooseClothingSize(){
        System.out.println("De que material esta principalmente hecha esta pieza de ropa? ");
        for (ClothingSizes clothingSize : ClothingSizes.values()) {
            System.out.println("- " + clothingSize.name());
        }
        Scanner scanner = new Scanner(System.in);
        ClothingSizes seleccion = null;
        while (seleccion == null) {
            try {
                String input = scanner.nextLine().toUpperCase();
                seleccion = ClothingSizes.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Selección inválida. Intente de nuevo.");
            }
        }
        return seleccion;
    }
    private static void loadUserMenu(User user){
        switch (user.getClass().getSimpleName()){
            case "Individual":
                individualMenu((Individual) user);
                break;
            case "Enterprise":
                enterpriseMenu((Enterprise) user);
                break;
            case "Supplier":
                supplierMenu((Supplier)user);
                break;
        }
    }


    private static void addDefaultData(){
        shop.addUser(new Individual(
                "pepe",
                "pepe1",
                "pepe pepe",
                LocalDate.of(2002, 12, 21),
                617282920,
                "pepe@pepe.com",
                "calle pepe",
                new ArrayList<Order>()));
        shop.addUser(new Enterprise(
                "HolaSA",
                "1234",
                "54577432",
                "EmpresasHolaSA",
                617111252,
                "empresa1@mail.com",
                "calle falsa 123",
                new ArrayList<Order>()));

        shop.addUser(new Supplier(
                "HolaSA",
                "1234",
                "54577432"));


        shop.getProductList().add(new Clothing("HolaSA", "Camiseta de manga corta", 10.99f, 200, "N/A", ClothingMaterials.POLYESTER, ClothingSizes.M));
        shop.getProductList().add(new Technology("HolaSA", "Portatil ThinkPad x56", 556.59f, 5,"Lenovo", "2187A41121"));
        shop.getProductList().add(new Edible("Default Supplier S.A", "Manzana", 0.75f, 100, "Hacendado",  "100% Manzana natural"));
        shop.getProductList().add(new Clothing("Default Supplier S.A", "Camiseta de manga larga", 12.99f, 200, "N/A", ClothingMaterials.COTTON, ClothingSizes.L));
        shop.getProductList().add(new Technology("HolaSA", "Asus Rog Strix G", 899.99f, 2,"Asus", "213015812A"));



    }

}