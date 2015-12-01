package vn.fpt.se0866.model;

import java.io.Serializable;

/**
 * Created by DatHT on 11/15/2015.
 */
public class Food implements Serializable {
    private int foodId;
    private String foodName;
    private String description;
    private String avatarLink;


    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
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
}
