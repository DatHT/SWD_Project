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
public class FoodDTO {

    private String foodName;
    private String recipe;
    private int categoryID;
    private String linkImage;
    private String ListMaterial;

    public FoodDTO(String foodName, String recipe, int categoryID, String linkImage, String ListMaterial) {
        this.foodName = foodName;
        this.recipe = recipe;
        this.categoryID = categoryID;
        this.linkImage = linkImage;
        this.ListMaterial = ListMaterial;
    }

    public String getListMaterial() {
        return ListMaterial;
    }

    public void setListMaterial(String ListMaterial) {
        this.ListMaterial = ListMaterial;
    }
    

  
    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

}
