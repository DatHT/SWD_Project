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
    private String tutorial;
    private int categoryID;
    private String linkImage;
    private String ListMaterial;
    private String Content;
    private String ListMaterialInfo;
    private String User;
    private int VisitNum;

    public FoodDTO(String foodName, String tutorial, int categoryID, String linkImage, String ListMaterial, String Content, String ListMaterialInfo) {
        this.foodName = foodName;
        this.tutorial = tutorial;
        this.categoryID = categoryID;
        this.linkImage = linkImage;
        this.ListMaterial = ListMaterial;
        this.Content = Content;
        this.ListMaterialInfo = ListMaterialInfo;
        this.User = "Admin";
        this.VisitNum = 0;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

  

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getListMaterial() {
        return ListMaterial;
    }

    public void setListMaterial(String ListMaterial) {
        this.ListMaterial = ListMaterial;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getListMaterialInfo() {
        return ListMaterialInfo;
    }

    public void setListMaterialInfo(String ListMaterialInfo) {
        this.ListMaterialInfo = ListMaterialInfo;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public int getVisitNum() {
        return VisitNum;
    }

    public void setVisitNum(int VisitNum) {
        this.VisitNum = VisitNum;
    }
    

    
    

}
