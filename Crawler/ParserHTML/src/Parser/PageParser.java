/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parser;

import DBUtils.Material;

/**
 *
 * @author HienLN
 */
public abstract class PageParser {
    public abstract void parseCategory(String page);
    public abstract void parseFood(String page, String category);
}
