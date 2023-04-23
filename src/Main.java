import models.*;
import models.enums.*;
import utils.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
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

    private static void addDefaultData(){

        ProductList.addProduct(new Clothing("Default Supplier S.A", "Camiseta de manga corta", 10.99f, 200, "N/A", ClothingMaterials.POLYESTER, ClothingSizes.M));
        ProductList.addProduct(new Technology("Default Supplier S.A", "Portatil ThinkPad x56", 556.59f, 5,"Lenovo", 218741121));
        ProductList.addProduct(new Edible("Default Supplier S.A", "Manzana", 0.75f, 100, "Hacendado",  EdibleCategory.FRUIT));
        ProductList.addProduct(new Clothing("Default Supplier S.A", "Camiseta de manga larga", 12.99f, 200, "N/A", ClothingMaterials.COTTON, ClothingSizes.L));
        ProductList.addProduct(new Technology("Default Supplier S.A", "Asus Rog Strix G", 899.99f, 2,"Asus", 213015812));




        //
        ArrayList<Order> individualUnoOrders = new ArrayList<Order>();
        individualUnoOrders.add(new Order(null, LocalDate.now(), LocalDate.of(2023, 5, 1)));
        ArrayList<Order> individualDosOrders = new ArrayList<Order>();



        UserList.addUser(new Individual("Pepe123", "1234", "pepe perez", LocalDate.of(1920,01,31), 617111252, "pepe@gmail.com", "calle falsa 123", individualUnoOrders));

        UserList.addUser(new Individual("Pepe123", "1234", "pepe perez", LocalDate.of(1920,01,31), 617111252, "pepe@gmail.com", "calle falsa 123", individualUnoOrders));


        ArrayList<Order> EnterpriseUnoOrders = new ArrayList<Order>();
        UserList.addUser(new Enterprise("HolaSA", "1234", "54577432", "EmpresasHolaSA", 617111252, "empresa1@mail.com", "calle falsa 123", EnterpriseUnoOrders));


        // SUPPLIER MERCADONA ------------------------
        // declaramos los arrays de tiendas y pedidos
        ArrayList<Shop> mercadonaShops = new ArrayList<Shop>();
        ArrayList<Order> mercadonaOrders = new ArrayList<Order>();

        //pedido 1
        ArrayList<GenericProduct> order1Products = new ArrayList<GenericProduct>();
        order1Products.add(new Edible("Mercadona", "Huevos", 1.99f, 100, "Hacendado",  EdibleCategory.DAIRY));
        order1Products.add(new Edible("Mercadona", "Leche", 0.69f, 125, "Hacendado",  EdibleCategory.DAIRY));

        //pedido 2
        ArrayList<GenericProduct> order2Products = new ArrayList<GenericProduct>();
        order2Products.add(new Edible("Mercadona", "Yogur", 0.99f, 100, "Hacendado",  EdibleCategory.DAIRY));
        order2Products.add(new Edible("Mercadona", "Queso", 1.99f, 100, "Hacendado",  EdibleCategory.DAIRY));
        order2Products.add(new Edible("Mercadona", "Leche", 0.69f, 125, "Hacendado",  EdibleCategory.DAIRY));

        //declaracion de pedidos
        Order mercadonaOrder1 = new Order( order1Products, LocalDate.now(), LocalDate.of(2023, 5, 1));
        Order mercadonaOrder2 = new Order( order2Products, LocalDate.now(), LocalDate.of(2023, 5, 1));

        // declaramos el array de productos de la tienda
        ArrayList<GenericProduct> mercadonaBCNProducts = new ArrayList<GenericProduct>();

        //declaramos la tienda con sus productos
        Shop mercadonaBCN = new Shop("Mercadona BCN", mercadonaOrders,  mercadonaBCNProducts);
        mercadonaBCN.addProduct(new Edible("Mercadona", "Huevos", 1.99f, 100, "Hacendado",  EdibleCategory.DAIRY));
        mercadonaBCN.addProduct(new Edible("Mercadona", "Leche", 0.69f, 125, "Hacendado",  EdibleCategory.DAIRY));
        mercadonaBCN.addProduct(new Edible("Mercadona", "Yogur", 0.99f, 100, "Hacendado",  EdibleCategory.DAIRY));
        mercadonaBCN.addProduct(new Edible("Mercadona", "Queso", 1.99f, 100, "Hacendado",  EdibleCategory.DAIRY));
        mercadonaShops.add(mercadonaBCN);

        //creamos el usuario y añadimos la tienda a la lista de tiendas del supplier
        User mercadonaUser = new Supplier("mercadonaadmin", "1234", "Mercadona", mercadonaShops);
        UserList.addUser(mercadonaUser);
        ((Supplier)mercadonaUser).addShop(mercadonaBCN);

    }

    private static void addUserToList(User user) {
        System.out.println("Añadiendo usuario "+ user.toString() +  " a la base de datos...");
        UserList.addUser(user);
    }
}