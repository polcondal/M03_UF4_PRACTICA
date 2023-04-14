package models;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect(String password, User user){
        return user.getPassword().equals(password);
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public int countUsers() {
        return users.size();
    }

    public UserList() {
        users = new ArrayList<User>();
    }

}
