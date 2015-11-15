/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import DBUtils.CategoryDTO;
import DBUtils.Dao;
import DBUtils.FoodDTO;
import DBUtils.Material;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author HienLN
 */
public class Page extends PageParser {

    private List<String> linkcategory;
    private List<String> categoryName;

    public Page() {

    }

    @Override
    public void parseCategory(String page) {
        try {
            Document doc = Jsoup.connect(page).get();
            Elements listcate = doc.select("li#menu-item-4658>ul.sub-menu>li a");
            linkcategory = new ArrayList<String>();
            categoryName = new ArrayList<String>();
            for (Element element : listcate) {
                CategoryDTO category = new CategoryDTO(element.text());
                linkcategory.add(element.attr("href"));
                categoryName.add(element.text());
                Dao dao = new Dao();
                dao.AddCategory(category);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void parseFood(String page, String category) {
        String recipe = "";
        String FoodName = "";
        String linkImage = "";
        String Listmateral_Quantity = "";
        List<String> ListMaterial, ListQuantity;
        ListMaterial = new ArrayList<String>();
        ListQuantity = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect(page).get();
            //Get FoodName
            Elements Foodname = doc.select("h2.entry-title>a[title]");
            for (Element element : Foodname) {
                FoodName = element.text();
            }
            //Get LinkImage
            Elements Image = doc.select("a[rel=prettyPhoto[slides]]");
            for (Element element : Image) {
                linkImage = element.attr("href");
            }
            // Get Recipe
            Elements cachlam = doc.select("div[class=instructions]>*");
            for (Element element : cachlam) {
                recipe = recipe + "\n" + element.text();
            }
            // Get Material and Quantity
            Elements material = doc.select("ul.ingredients>li");
            for (Element element : material) {
                ListMaterial.add(element.select("a[href]").text().trim());
                ListQuantity.add(element.select("span").text().trim());
            }
            for (int i = 0; i <= ListMaterial.size() - 1; i++) {
                Listmateral_Quantity = Listmateral_Quantity + ListMaterial.get(i) + "-" + ListQuantity.get(i) + ';';
            }
            Dao dao = new Dao();
            int categoryID = dao.getCategoryID(category);
            FoodDTO food = new FoodDTO(FoodName, recipe, categoryID, linkImage,Listmateral_Quantity);
            dao.AddFood(food);
            for (int i = 0; i <= ListMaterial.size()-1;i++){
                if (dao.getMaterialID(ListMaterial.get(i))== -1){
                    String listID ="";
                    listID = listID + Integer.toString(dao.getFoodID(FoodName))+";";
                    Material materialDTO = new Material(ListMaterial.get(i),listID);
                    dao.AddMaterial(materialDTO);
                } else {
                    String listID = dao.getListIDFromMaterial(dao.getMaterialID(ListMaterial.get(i)));
                    listID = listID + Integer.toString(dao.getFoodID(FoodName))+";";
                    Material materialDTO = new Material(ListMaterial.get(i), listID);
                    dao.updateMaterial(materialDTO);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public int pagenumber(String category) {
        String pagenumber = "";
        int number = 0;
        try {
            Document doc = Jsoup.connect(category).get();
            Elements listpage = doc.select("section#content>div>a[href]");
            Element page = listpage.get(listpage.size()-1);
            pagenumber = page.attr("href");
            int beginIndex = pagenumber.indexOf("page") + 5;
            int lastIndex = pagenumber.length() - 1;
            pagenumber = pagenumber.substring(beginIndex, lastIndex);
            number = Integer.parseInt(pagenumber);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return number;
    }

    public void scaning() {
        for (int j = 0; j <= linkcategory.size() - 1; j++) {
            try {
                Document doc = Jsoup.connect(linkcategory.get(j)).get();
                int number = pagenumber(linkcategory.get(j));
                for (int i = 1; i <= number; i++) {
                    String link = "";
                    if (i == 1) {
                        link = linkcategory.get(j);
                    } else {
                        link = linkcategory.get(j) + "page/" + Integer.toString(i) + "/";
                    }
                    Document docgetfood = Jsoup.connect(link).get();
                    Elements listlinkfood = docgetfood.select("article>a[href]");
                    for (Element element : listlinkfood) {
                        String linktmp = element.attr("href");
                        parseFood(linktmp, categoryName.get(j));
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
