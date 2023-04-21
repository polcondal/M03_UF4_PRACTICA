package models;

import models.enums.ClothingMaterials;
import models.enums.ClothingSizes;

public class Clothing extends GenericProduct{

    private ClothingMaterials clothingMaterials;
    private ClothingSizes clothingSizes;

    //constructor directo
    public Clothing(String supplierName, String productName, float price, int stock, String brand, ClothingMaterials clothingMaterials, ClothingSizes clothingSizes) {
        super(supplierName, productName, price, stock, brand);
        this.clothingMaterials = clothingMaterials;
        this.clothingSizes = clothingSizes;
    }

    public ClothingMaterials getClothingMaterials() {
        return clothingMaterials;
    }
    public void setClothingMaterials(ClothingMaterials clothingMaterials) {
        this.clothingMaterials = clothingMaterials;
    }

    public ClothingSizes getClothingSizes() {
        return clothingSizes;
    }
    public void setClothingSizes(ClothingSizes clothingSizes) {
        this.clothingSizes = clothingSizes;
    }


}
