/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crawler;

import page.Monan9;
import page.Sotaynauan;

/**
 *
 * @author HienLN
 */
public class Crawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Sotaynauan sotaynauan = new Sotaynauan();
//        sotaynauan.scanning("http://sotaynauan.com/");
        Monan9 monan9 = new Monan9();
        monan9.scanning("http://monan9.com/");
    }
    
}
