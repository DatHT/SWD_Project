/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HienLN
 */
public class Dao implements Serializable {

    public boolean AddFood(FoodDTO food) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "INSERT INTO `nauan`.`tbl_food` "
                    + "(`FoodName`, `Tutorial`, `CategoryID`, `LinkImage`, `MaterialInfo`, `ListMaterial`, `VisitNum`, `User`, `Content`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?);";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, food.getFoodName());
                stm.setString(2, food.getTutorial());
                stm.setInt(3, food.getCategoryID());
                stm.setString(4, food.getLinkImage());
                stm.setString(5, food.getListMaterialInfo());
                stm.setString(6, food.getListMaterial());
                stm.setInt(7, food.getVisitNum());
                stm.setString(8, food.getUser());
                stm.setString(9, food.getContent());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }

    public boolean AddMaterial(Material material) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "INSERT INTO `nauan`.`tbl_material` (`MateialName`) VALUES (?);";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, material.getMaterialName());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(material.getMaterialName());
            } finally {
                try {
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }

    public int getfoodID(String foodname) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select FoodID from tbl_food where FoodName=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, foodname);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("FoodID");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }

    public int getMaterialID(String materialname) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select MaterialID from tbl_material where MateialName=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, materialname);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("MaterialID");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }
     public int getFoodID(String Foodname) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select FoodID from tbl_food where FoodName=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, Foodname);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("FoodID");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }
    public int getCategoryID(String categoryName) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select CategoryID from tbl_category where CategoryName=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, categoryName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("CategoryID");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }
//    public boolean AddFoodMaterial(String foodname, String materialname, String weigh){
//        int foodID = getfoodID(foodname);
//        int materialID = getMaterialID(materialname);
//        Connection con = DBUtils.makeConnection();
//        PreparedStatement stm = null;
//        if (con != null) {
//            String sql = "INSERT INTO `nauan`.`tbl_food_material` (`MaterialID`, `FoodID`, `Weigh`) VALUES (?,?,?);";
//            try {
//                stm = con.prepareStatement(sql);
//                stm.setInt(1, materialID);
//                stm.setInt(2, foodID);
//                stm.setString(3, weigh);
//                int row = stm.executeUpdate();
//                if (row > 0) {
//                    return true;
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (stm != null) {
//                        stm.close();
//                    }
//                    if (con != null) {
//                        con.close();
//                    }
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//
//            }
//
//        }
//        return false;
//        
//    }

    public boolean AddCategory(CategoryDTO category) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "INSERT INTO `nauan`.`tbl_category` (`CategoryName`) VALUES (?);";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, category.getCategoryName());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }

    public boolean checkMaterial(String materialname) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select MaterialID from tbl_material where MaterialID=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setInt(1, getMaterialID(materialname));
                rs = stm.executeQuery();
                if (rs != null) {
                    return false;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return true;
    }

//    public boolean updateMaterial(Material material) {
//        Connection con = DBUtils.makeConnection();
//        PreparedStatement stm = null;
//        if (con != null) {
//            String sql = "UPDATE `nauan`.`tbl_material` SET `ListFood`=? WHERE `MaterialID`=?;";
//            try {
//                stm = con.prepareStatement(sql);
//                stm.setString(1, material.getListID());
//                stm.setInt(2, getMaterialID(material.getMaterialName()));
//                int row = stm.executeUpdate();
//                if (row > 0) {
//                    return true;
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (stm != null) {
//                        stm.close();
//                    }
//                    if (con != null) {
//                        con.close();
//                    }
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//
//            }
//
//        }
//        return false;
//    }
    
    public String getListIDFromMaterial(int materialID){
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select ListFood from tbl_material where MaterialID=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setInt(1, materialID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getString("ListFood");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
}
