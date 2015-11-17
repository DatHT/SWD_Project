/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author HienLN
 */
public class DBUtils implements Serializable{
    public static Connection makeConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/iCookDB?user=root&password=lengochien";
            Connection con = DriverManager.getConnection(url);
            return con;        
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
