package models;

import models.enums.*;
// *imports all enums (clothing materials and clothing sizes)

public class Clothing extends GenericProduct {
    private ClothingSizes size;
    private ClothingMaterials material;

    public Clothing(int productId, int sellerId, String productName, float price, int stock, String brand,
            ClothingSizes size,
            ClothingMaterials material) {
        super(productId, sellerId, productName, price, stock, brand);
        this.size = size;
        this.material = material;
    }
}
