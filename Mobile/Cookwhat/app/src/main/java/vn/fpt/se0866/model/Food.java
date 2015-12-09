package vn.fpt.se0866.model;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

/**
 * Created by DatHT on 11/15/2015.
 */

public class Food implements Serializable {
    @DatabaseField(id = true)
    private int foodId;

    @DatabaseField
    private String foodName;

    @DatabaseField
    private String description;

    @DatabaseField
    private String avatarLink;

    @DatabaseField
    private String materialDetail;

    @DatabaseField
    private String tutorial;

    @DatabaseField
    private String source;

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
}
