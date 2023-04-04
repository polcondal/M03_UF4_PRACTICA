package models;

public abstract class User {
    private int userId = 0;
    private String userName = "";
    private String loginPassword = "";

    public User(int userId, String userName, String loginPassword) {
        this.userId = userId;
        this.userName = userName;
        this.loginPassword = loginPassword;
    }

}
