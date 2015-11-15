/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBUtils;

/**
 *
 * @author HienLN
 */
public class Food_Material {
    private int foodID;
    private int materialID;
    private String  weight;

    public Food_Material(int foodID, int materialID, String weight) {
        this.foodID = foodID;
        this.materialID = materialID;
        this.weight = weight;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
}
