package models;

import utils.Utilities;

import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsersArrayList() {
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

    public static boolean doesUserExist(String username, String email) {
        for (User user : users) {
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

    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static int countUsers() {
        return users.size();
    }
}

