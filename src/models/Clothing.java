package models;

import models.enums.ClothingMaterials;
import models.enums.ClothingSizes;
import models.enums.EdibleCategory;

public class Clothing extends GenericProduct{

    private ClothingMaterials clothingMaterials;
    private ClothingSizes clothingSizes;

    public Clothing(int productId, int sellerId, String productName, float price, int stock, String brand) {
        super(productId, sellerId, productName, price, stock, brand);
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
