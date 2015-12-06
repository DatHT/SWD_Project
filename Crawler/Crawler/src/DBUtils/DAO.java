/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import DTO.CategoryDTO;
import DTO.FoodDTO;
import DTO.FoodDetailDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class Data Access Object 
 * @author HienLN
 */
public class DAO implements Serializable {

    /**
     * Method AddFood: 
     * Add food to database
     * @author HienLN
     */
    public boolean AddFood(FoodDTO food) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "INSERT INTO `icookdb`.`tbl_food` "
                    + "(`FoodName`, `Description`, `AvatarLink`, `VisitNum`, `ListMaterial`, `CategoryID`) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, food.getFoodName());
                stm.setString(2, food.getDescription());
                stm.setString(3, food.getAvatarLink());
                stm.setInt(4, food.getVisitNum());
                stm.setString(5, food.getListMaterial());
                stm.setInt(6, food.getCategoryID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    System.out.println("INFO: Insert Food Success | FoodName: " + food.getFoodName());
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Insert Food Fail | FoodName: " + food.getFoodName());
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }

    /**
     * Method getfoodID:
     * get foodID in database
     * @author HienLN
     */
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
                System.out.println("ERROR: Get FoodID Fail | FoodName: " + foodname);
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }
    
    /**
     * Method getfoodDetail:
     * get foodID in database
     * @author HienLN
     */
    public int getfoodDetailID(int foodID) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select FoodID from tbl_fooddetail where FoodID=?";
            try {
                stm = con.prepareStatement(sql);
                stm.setInt(1, foodID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("FoodID");
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: Get FoodDetail Fail | FoodID: " + foodID);
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }
    /**
     * Method getCategoryID:
     * get getCategoryID in database
     * @author HienLN
     */
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
                System.out.println("ERROR: Get Category Fail | Category: " + categoryName);
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }
            }
        }
        return -1;
    }
    
     /**
     * Method AddCategory:
     * get Add a Category to database
     * @author HienLN
     */
    public boolean AddCategory(CategoryDTO category) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "INSERT INTO `iCookDB`.`tbl_category` (`CategoryName`) VALUES (?);";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, category.getCategoryName());
                int row = stm.executeUpdate();
                if (row > 0) {
                    System.out.println("INFO: Insert Category Success | CategoryName: " + category.getCategoryName());
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Insert Category Fail | CategoryName: " + category.getCategoryName());
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }
    
     /**
     * Method AddFoodDetail:
     * get Add a FoodDetail(presentation of food in type html) to database
     * @author HienLN
     */
    public boolean AddFoodDetail(FoodDetailDTO foodDetail) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "INSERT INTO `icookdb`.`tbl_fooddetail` (`FoodID`, `MaterialDetail`, `Tutorial`, `Source`, `UserID`) "
                    + "VALUES (?, ?, ?, ?, ?);";
            try {
                stm = con.prepareStatement(sql);
                stm.setInt(1, foodDetail.getFoodID());
                stm.setString(2, foodDetail.getMaterialDetail());
                stm.setString(3, foodDetail.getTutorial());
                stm.setString(4, foodDetail.getSource());
                stm.setString(5, foodDetail.getUserID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    System.out.println("INFO: Insert FoodDetail Success | FoodID: " + foodDetail.getFoodID());
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Insert FoodDetail Fail | FoodDetailID: " + foodDetail.getFoodID());
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }
   
    /**
     * Method UpdateFood:
     * get Update a Food in database
     * @author HienLN
     */
    public boolean UpdateFood(FoodDTO food, int foodID) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "UPDATE `icookdb`.`tbl_food` SET "
                    + "`FoodName`=?, `Description`=?, `AvatarLink`=?, `VisitNum`=?, `ListMaterial`=?, `CategoryID`=? "
                    + "WHERE `FoodID`=?;";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, food.getFoodName());
                stm.setString(2, food.getDescription());
                stm.setString(3, food.getAvatarLink());
                stm.setInt(4, food.getVisitNum());
                stm.setString(5, food.getListMaterial());
                stm.setInt(6, food.getCategoryID());
                stm.setInt(7, foodID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    System.out.println("INFO: Update Food Success | FoodName: " + food.getFoodName());
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Update Food Fail | FoodName: " + food.getFoodName());
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }

    /**
     * Method UpdateFoodDetail:
     * get Update a FoodDetail(presentation of food in type html) in database
     * @author HienLN
     */
    public boolean UpdateFoodDetail(FoodDetailDTO foodDetail) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        if (con != null) {
            String sql = "UPDATE `icookdb`.`tbl_fooddetail` SET "
                    + "`MaterialDetail`=?, `Tutorial`=?, `Source`=?, `UserID`=? "
                    + "WHERE `FoodID`=?;";
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, foodDetail.getMaterialDetail());
                stm.setString(2, foodDetail.getTutorial());
                stm.setString(3, foodDetail.getSource());
                stm.setString(4, foodDetail.getUserID());
                stm.setInt(5, foodDetail.getFoodID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    System.out.println("INFO: Update FoodDetail Success | FoodID: " + foodDetail.getFoodID());
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Update FoodDetail Fail | FoodDetailID: " + foodDetail.getFoodID());
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
                    System.out.println("ERROR: Close Connection Fail !");
                    ex.printStackTrace();
                }

            }

        }
        return false;
    }
}
