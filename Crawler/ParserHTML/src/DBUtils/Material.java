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
public class Material {

    private String materialName;
    private String ListID;

    public Material(String materialName, String ListID) {
        this.materialName = materialName;
        this.ListID = ListID;
    }

    public String getListID() {
        return ListID;
    }

    public void setListID(String ListID) {
        this.ListID = ListID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

}
