package models;

import java.util.ArrayList;
import utils.Utilities;

public class Shop {
    private String shopName;
    private ArrayList<Order> orderList;
    private ArrayList<GenericProduct> productList;

    public Shop(String shopName){
        this.shopName = shopName;
        orderList = new ArrayList<Order>();
        productList = new ArrayList<GenericProduct>();
    }

    public void shopMenu(){
        System.out.println("Welcome to " + shopName + "!" + "\n" +
                "1. Gestionar Productos \n" +
                "2. Gestionar Pedidos \n" +
                "3. Volver");
        int option = Utilities.leerInt("Introduce una opción: ", 1, 3);
        int suboption = 0;
        switch (option){
            case 1:
                System.out.println("Gestionar Productos");
                System.out.println("1. Añadir Producto \n" +
                        "2. Eliminar Producto \n" +
                        "3. Listar Productos \n" +
                        "4. Volver");
                suboption = Utilities.leerInt("Introduce una opción: ", 1, 4);
                break;
            case 2:
                System.out.println("Gestionar Pedidos");
                System.out.println("1. Añadir Pedido \n" +
                        "2. Eliminar Pedido \n" +
                        "3. Listar Pedidos \n" +
                        "4. Volver");
                suboption = Utilities.leerInt("Introduce una opción: ", 1, 4);

                switch (suboption){
                    case 1:
                        System.out.println("Añadir Pedido");
                        int productId = Utilities.leerInt("Introduce el ID del producto: ", 1, productList.size());
                        int quantity = Utilities.leerInt("Introduce la cantidad: ", 1, 100);
                        // orderList.add(new Order(quantity));
                        break;
                    case 2:
                        System.out.println("Eliminar Pedido");
                        orderList.remove(Utilities.leerInt("Introduce el ID del pedido: ", 1, orderList.size()));
                        break;
                    case 3:
                        System.out.println("Listar Pedidos");
                        for(int i = 0; i<orderList.size(); i++){
                            System.out.println("Pedido " + (i+1) + ": " + orderList.get(i));
                        }
                        break;
                    case 4:
                        System.out.println("Volver");
                        break;
                }


                break;
            case 3:
                System.out.println("Saliendo de la tienda" + shopName + "...");
                break;
        }

    }

    public ArrayList<Order> getOrderList(){
        return orderList;
    }
    public Order getOrderById(int id){
        for(int i = 0; i<orderList.size(); i++){
            if(orderList.get(i).getOrderId() == id){
                return orderList.get(i);
            }
        }
        return null;
    }
    public void setOrderById(int id, Order newOrder){
        for(int i = 0; i<orderList.size(); i++){
            if(orderList.get(i).getOrderId() == id){
                orderList.set(i, newOrder);
            }
        }
    }
    public void addOrder(Order order){
        orderList.add(order);
    }

    public ArrayList<GenericProduct> getProductList(){
        return productList;
    }
    public GenericProduct getProductById(int id){
        for(int i = 0; i<productList.size(); i++){
            if(productList.get(i).getProductId() == id){
                return productList.get(i);
            }
        }
        return null;
    }
    public void setProductById(int id, GenericProduct newProduct){
        for(int i = 0; i<productList.size(); i++){
            if(productList.get(i).getProductId() == id){
                productList.set(i, newProduct);
            }
        }
    }
    public void addProduct(GenericProduct product){
        productList.add(product);
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
