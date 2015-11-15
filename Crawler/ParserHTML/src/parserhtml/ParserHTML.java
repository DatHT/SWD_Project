/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parserhtml;

import DBUtils.Dao;
import DBUtils.FoodDTO;
import Parser.Page;
import Parser.PageParser;
import java.sql.Connection;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author HienLN
 */
public class ParserHTML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", " org.apache.commons.logging.impl.NoOpLog");
        Page page = new Page();
        page.parseCategory("http://sotaynauan.com/");
        page.scaning();
    }
    
}
