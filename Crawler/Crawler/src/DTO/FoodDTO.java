/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author HienLN
 */
public class FoodDTO {
    private String foodName;
    private String description;
    private String avatarLink;
    private int visitNum;
    private String listMaterial;
    private int categoryID;

    public FoodDTO(String foodName, String description, String avatarLink, int visitNum, String listMaterial, int categoryID) {
        this.foodName = foodName;
        this.description = description;
        this.avatarLink = avatarLink;
        this.visitNum = visitNum;
        this.listMaterial = listMaterial;
        this.categoryID = categoryID;
    }

    public FoodDTO() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    public String getListMaterial() {
        return listMaterial;
    }

    public void setListMaterial(String listMaterial) {
        this.listMaterial = listMaterial;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
}
