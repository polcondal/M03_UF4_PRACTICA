package models;

public abstract class User {

    private static int userId = 0;
    private String username;
    private String password;

    public User(String userName, String loginPassword) {
        this.username = userName;
        this.password = loginPassword;
        userId ++;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void removeAccount(UserList userList) {
        userList.removeUser(this);
    }

}
