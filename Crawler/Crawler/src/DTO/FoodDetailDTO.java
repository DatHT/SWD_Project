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
public class FoodDetailDTO {
    private int foodID;
    private String materialDetail;
    private String tutorial;
    private String source;
    private String userID;

    public FoodDetailDTO() {
    }

    public FoodDetailDTO(int foodID, String materialDetail, String tutorial, String source, String userID) {
        this.foodID = foodID;
        this.materialDetail = materialDetail;
        this.tutorial = tutorial;
        this.source = source;
        this.userID = userID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getMaterialDetail() {
        return materialDetail;
    }

    public void setMaterialDetail(String materialDetail) {
        this.materialDetail = materialDetail;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
