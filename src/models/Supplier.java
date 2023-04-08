package models;
import interfaces.UserAccount;

public class Supplier extends User implements UserAccount {
    // TODO: TODO
    // QUE NO TENGA UNA LISTA DE PRODUCTOS, PERO QUE SEA EL UNICO QUE TENGA PERMISOS PARA AÑADIR PRODUCTOS A LA TIENDA DESDE EL MENU
    public Supplier(String userName, String loginPassword) {
        super(userName, loginPassword);
    }

    @Override
    public void createAccount() {
    //TODO: IMPLEMENTAR
    }

    @Override
    public void removeAccount() {

    }

    @Override
    public void modifyAccount() {

    }


}
