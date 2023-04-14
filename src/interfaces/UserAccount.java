package interfaces;

import models.User;
import models.UserList;

public interface UserAccount {
    public void createAccount();

    public void removeAccount(UserList userList);

    public void modifyAccount();

}
