package models;
import  utils.Utilities;

public abstract class User {

    private static int userIdCounter = 0;
    private int userId;
    private String username;
    private String password;

    public User(String userName, String loginPassword) {
        userIdCounter++;
        this.userId = userIdCounter;
        this.username = userName;
        this.password = loginPassword;
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


    public void ChangePassword() {
        String oldPassword;
        do {
            oldPassword = Utilities.leerPalabra("Introduce la contraseña actual: ");
            if (!oldPassword.equals(this.password))
                System.out.println("Contraseña incorrecta.");
        } while (!oldPassword.equals(this.password));

        String newPassword;
        do {
            newPassword = Utilities.leerPalabra("Introduce la nueva contraseña: ");
            if (newPassword.equals(oldPassword))
                System.out.println("La nueva contraseña no puede ser igual a la anterior.");
        } while (newPassword.equals(oldPassword));

        setPassword(newPassword);
    }

}
