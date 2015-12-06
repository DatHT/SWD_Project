/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import DBUtils.DAO;
import DTO.CategoryDTO;
import DTO.FoodDTO;
import DTO.FoodDetailDTO;
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
public class Monan9 implements parser {

    private List<String> linkcategory;
    private List<String> categoryName;

    @Override
    public void scanning(String page) {
        try {
            Document doc = Jsoup.connect(page).get();
            parseCategory(doc);
            for (int i = 0; i < linkcategory.size(); i++) {
                Document local = Jsoup.connect(linkcategory.get(i)).get();
                boolean next = true;
                while (next) {
                    for (Element foodpage : local.select("article>header>h2>a")) {
                        String linkFoodPage = foodpage.attr("href");
                        Document docFood = Jsoup.connect(linkFoodPage).get();

                        DAO dao = new DAO();
                        FoodDTO food = new FoodDTO();

                        food.setFoodName(parseFoodName(docFood));
                        food.setDescription(parseDescription(docFood));
                        food.setAvatarLink(parseAvatarLink(docFood));
                        food.setListMaterial(parseListMaterial(docFood));
                        food.setCategoryID(dao.getCategoryID(categoryName.get(i)));
                        food.setVisitNum(0);

                        if (dao.getfoodID(food.getFoodName()) == -1) {
                            dao.AddFood(food);
                            FoodDetailDTO foodDetail = new FoodDetailDTO();
                            foodDetail.setFoodID(dao.getfoodID(food.getFoodName()));
                            foodDetail.setMaterialDetail(parseMaterialHTML(docFood));
                            foodDetail.setTutorial(parseTutorialHTML(docFood));
                            foodDetail.setSource(page);
                            foodDetail.setUserID("ADMIN");
                            if (dao.getfoodDetailID(foodDetail.getFoodID()) == -1) {
                                dao.AddFoodDetail(foodDetail);
                            } else {
                                dao.UpdateFoodDetail(foodDetail);
                            }

                        } else {
                            int foodID = dao.getfoodID(food.getFoodName());
                            dao.UpdateFood(food, foodID);
                            FoodDetailDTO foodDetail = new FoodDetailDTO();
                            foodDetail.setFoodID(foodID);
                            foodDetail.setMaterialDetail(parseMaterialHTML(docFood));
                            foodDetail.setTutorial(parseTutorialHTML(docFood));
                            foodDetail.setSource(page);
                            foodDetail.setUserID("ADMIN");
                            if (dao.getfoodDetailID(foodDetail.getFoodID()) == -1) {
                                dao.AddFoodDetail(foodDetail);
                            } else {
                                dao.UpdateFoodDetail(foodDetail);
                            }
                        }
                    }
                    if (local.select("div[class=pagination-next alignright]").size() == 0) {
                        next = false;
                    } else {
                        String link = "";
                        Elements link_local = local.select("div[class=pagination-next alignright]>a");
                        for (Element element : link_local) {
                            link = element.attr("href");
                        }
                        local = Jsoup.connect(link).get();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void parseCategory(Document doc) {
        Elements listCate = doc.select("ul#menu-main>li");
        linkcategory = new ArrayList<String>();
        categoryName = new ArrayList<String>();
        for (Element element : listCate) {
            if (!element.id().equals("menu-item-11") && !element.className().equals("right search")) {
                CategoryDTO category = new CategoryDTO(element.select("a").text());
                linkcategory.add(element.select("a").attr("href"));
                categoryName.add(element.select("a").first().text());
                DAO dao = new DAO();
                if (dao.getCategoryID(element.text()) == -1) {
                    dao.AddCategory(category);
                }
            }
        }
    }

    @Override
    public String parseFoodName(Document doc) {
        String foodName = "";
        Elements foodName_html = doc.select("header.entry-header>h1.entry-title");
        for (Element element : foodName_html) {
            foodName = element.text();
        }
        return foodName;
    }

    @Override
    public String parseAvatarLink(Document doc) {
        String avatarLink = "";
        Element linkImage_html = doc.select("img[src$=.jpg]").first();
        if (linkImage_html != null) {
            avatarLink = linkImage_html.attr("src");
        }
        return avatarLink;
    }

    @Override
    public String parseListMaterial(Document doc) {
        String listMaterial = "";
        Elements material_html = doc.select("div.entry-content>ol");
        for (Element element : material_html) {
            if ((!element.className().equals("comment-list")) && (element.select("li>*").size() == 0)) {
                for (Element element1 : element.select("li")) {
                    listMaterial = listMaterial + element1.text() + ";";
                }
                break;
            }
        }
        if (listMaterial.equals("")) {
            material_html = doc.select("div.entry-content>ul");
            for (Element element : material_html) {
                if ((!element.className().equals("comment-list")) && (element.select("li>*").size() == 0)) {
                    for (Element element1 : element.select("li")) {
                        listMaterial = listMaterial + element1.text() + ";";
                    }
                    break;
                }
            }

        }
        if (listMaterial.equals("")) {
            Elements material_html_type2 = doc.select("div.entry-content>*");
            int breakpoint = 0;
            for (Element element : material_html_type2) {
                if (breakpoint == 2) {
                    break;
                }
                if (breakpoint == 1) {
                    listMaterial = listMaterial + element.text() + ";";
                }
                if (element.tagName().equals("h3")) {
                    breakpoint++;
                }
            }
        }
        return listMaterial;
    }

    @Override
    public String parseDescription(Document doc) {
        String description = "";
        Element description_Html = doc.select("div.entry-content>p").first();
        if (description_Html != null) {
            description = description + description_Html.text();
        }
        return description;
    }

    @Override
    public String parseMaterialHTML(Document doc) {
        int count = 0;
        String materialHTML = "";
        Elements material_html = doc.select("div.entry-content>ol");
        for (Element element : material_html) {
            if ((!element.className().equals("comment-list")) && (element.select("li>*").size() == 0)) {
                materialHTML = materialHTML + element.outerHtml();
                break;
            }
        }
        if (materialHTML.equals("")) {
            material_html = doc.select("div.entry-content>ul");
            for (Element element : material_html) {
                if ((!element.className().equals("comment-list")) && (element.select("li>*").size() == 0)) {
                        materialHTML = materialHTML + element.outerHtml();
                        break;
                    }
                }
            }
            if (materialHTML.equals("")) {
                Elements material_html_type2 = doc.select("div.entry-content>*");
                int breakpoint = 0;
                for (Element element : material_html_type2) {
                    if (breakpoint == 2) {
                        break;
                    }
                    if (breakpoint == 1) {
                        materialHTML = materialHTML + element.outerHtml();
                    }
                    if (element.tagName().equals("h3")) {
                        breakpoint++;
                    }
                }
            }
            if (materialHTML.length() > 5000) {
                materialHTML = "";
            }
            return materialHTML;
        }

        @Override
        public String parseTutorialHTML
        (Document doc
        
            ) {
        int count = 0;
            String tutorialHTML = "";
            Elements tutorial_html = doc.select("div.entry-content>*");
            if (tutorial_html.size() > 0) {
                for (Element element : tutorial_html) {
                    if (count >= 2) {
                        if (element.select("strong>em>u").size() == 0) {
                            tutorialHTML = tutorialHTML + element.outerHtml();
                        } else {
                            break;
                        }
                    }
                    if (element.tagName().equals("h3")) {
                        count++;
                    }
                }
            }
            if (tutorialHTML.equals("")) {
                tutorial_html = doc.select("div.entry-content>*");
                if (tutorial_html.size() > 0) {
                    for (Element element : tutorial_html) {
                        if (count >= 1) {
                            if (element.select("strong>em>u").size() == 0) {
                                tutorialHTML = tutorialHTML + element.outerHtml();
                            } else {
                                break;
                            }
                        }
                        if (element.tagName().equals("ul") || element.tagName().equals("ol")) {
                            count++;
                        }
                    }
                }
            }
            return tutorialHTML;
        }

    }
