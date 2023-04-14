package models;
import interfaces.UserAccount;

import java.util.ArrayList;
import utils.Utilities;


public class Supplier extends User implements UserAccount {
    private String supplierName;
    private ArrayList<Shop> supplierShops = new ArrayList<Shop>();

    // TODO: TODO
    // QUE NO TENGA UNA LISTA DE PRODUCTOS, PERO QUE SEA EL UNICO QUE TENGA PERMISOS PARA AÑADIR PRODUCTOS A LA TIENDA DESDE EL MENU
    public Supplier(String userName, String loginPassword) {
        super(userName, loginPassword);
    }

    @Override
    public void createAccount() {
    //TODO: IMPLEMENTAR
        this.supplierName = Utilities.leerFrase("Introduce el nombre de proveedor: ", 3);
    }


    @Override
    public void modifyAccount() {

    }

    @Override
    public String toString(){
        return "Supplier [" +
                "userId='" + this.getUserId() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ']';
    }




}
