package models;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.Utilities;

public class Shop {
    private String shopName;
    private ArrayList<Order> orderList;
    private ArrayList<GenericProduct> productList;
    private ArrayList<User> userList;

    //constructor directo defaultData
    public Shop( String shopName, ArrayList<Order> orderList, ArrayList<GenericProduct> productList, ArrayList<User> userList){
        this.shopName = shopName;
        this.orderList = orderList;
        this.productList = productList;
        this.userList = userList;
    }

    //constructor para el usuario
    public Shop(String shopName){
        this.shopName = shopName;
        orderList = new ArrayList<Order>();
        productList = new ArrayList<GenericProduct>();
        userList = new ArrayList<User>();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<GenericProduct> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<GenericProduct> productList) {
        this.productList = productList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean doesUserExist(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesUserExist(String username, String email) {
        for (User user : userList) {
            //TEST
            if (user instanceof Client && user.getUsername().equals(username) && ((Client) user).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPasswordCorrect(String password, User user) {
        return user.getPassword().equals(password);
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean tryRemoveAccount(User user) {
        boolean isSure = Utilities.leerBoolean("¿Estás seguro de que quieres eliminar tu cuenta?");
        if (isSure) {
            removeUser(user);
            System.out.println("USUARIO BORRADO!");
        }
        return isSure;
    }

    public boolean tryRemoveProduct(Supplier supplier, String productName){
        for (GenericProduct product:productList) {
            if (product.getProductName().equals(productName) && product.getSupplierName().equals(supplier.getSupplierName())){
                productList.remove(product);
                return true;
            }
        }
        return false;

    }

    public void addProduct(GenericProduct product){
        productList.add(product);
    }

    public void showProductList(){
        System.out.println("------------------LISTA DE PRODUCTOS------------------");
        for (GenericProduct product: productList) {
            System.out.println(product.toString());
        }
    }

    public float CalculateBill(int productId, boolean isEnterprise, int quantity){
        GenericProduct product = isProductBuyable(productId, quantity);
        if(product != null){
            return calculatePrice(product, isEnterprise, quantity);
        }else{
            return 0.0f;
        }


    }


    public Order BuyProduct(int productId, boolean isEnterprise, int quantity){
        GenericProduct product = isProductBuyable(productId, quantity);
        updateProductStock(product, quantity);
        Order order = new Order(product, LocalDate.now(), LocalDate.now().plusDays(7));
        return order;
    }


    public float calculatePrice(GenericProduct product, boolean isEnterprise, int quantity){
        float subtotal = product.getPrice()*quantity;
        float total = subtotal * 1.15f;
        if (isEnterprise){
            total *= 0.90f;
        }
        return total;
    }

    public GenericProduct isProductBuyable(int productId, int newQuantity){
        for (GenericProduct product: productList) {
            if (product.getProductId()==productId){
                if (product.getStock()>= newQuantity){
                    return product;
                }
                return null;
            }
        }
        return null;
    }

    public void updateProductStock(GenericProduct product, int newQuantity){
            product.setStock(product.getStock()-newQuantity);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public int countUsers() {
        return userList.size();
    }

    @Override
    public String toString() {
        int orderCount = 0;
        for (Order order : orderList) {
            orderCount++;
        }

        int productCount = 0;
        for (GenericProduct genericProduct : productList) {
            productCount++;
        }

        int userCount = 0;
        for (User user : userList) {
            userCount++;
        }

        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", orderCount=" + orderCount +
                ", productCount=" + productCount +
                ", userCount=" + userCount +
                '}';
    }
}
