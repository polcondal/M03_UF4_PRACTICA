package models;

public abstract class User {

    private static String userId ;
    private String username;
    private String password;

    public User(String userName, String loginPassword) {
        this.userId += 1;
        this.username = userName;
        this.password = loginPassword;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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



}
