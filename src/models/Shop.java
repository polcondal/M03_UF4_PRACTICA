package models;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Order> orderList;
    private ArrayList<User> userList;
    private ArrayList<GenericProduct> productList;

    public Shop(){
        orderList = new ArrayList<Order>();
        userList = new ArrayList<User>();
        productList = new ArrayList<GenericProduct>();

    }

    //region Setters and getters OrderList
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
    //endregion

    //region Setters and getters models.UserList
    public ArrayList<User> getUserList(){
        return userList;
    }
    public User getUserById(int id){
        for(int i = 0; i<userList.size(); i++){
            if(userList.get(i).getUserId() == id){
                return userList.get(i);
            }
        }
        return null;
    }
    public User getUserByUsername(String username){
        for(int i = 0; i<userList.size(); i++){
            if(userList.get(i).getUsername() == username){
                return userList.get(i);
            }
        }
        return null;
    }
    public void setUserById(int id, User newUser){
        for(int i = 0; i<userList.size(); i++){
            if(userList.get(i).getUserId() == id){
                userList.set(i, newUser);
            }
        }
    }
    public void addUser(User user){
        userList.add(user);
    }

    //endregion

    //region Setters and getters ProductList
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
    //endregion


}
