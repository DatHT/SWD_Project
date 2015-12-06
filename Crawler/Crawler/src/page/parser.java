/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package page;

import org.jsoup.nodes.Document;

/**
 *
 * @author HienLN
 */
public interface parser {
    public void scanning(String page);
    public void parseCategory(Document doc);
    public String parseFoodName(Document doc);
    public String parseAvatarLink(Document doc);
    public String parseListMaterial(Document doc);
    public String parseDescription(Document doc);
    public String parseMaterialHTML(Document doc);
    public String parseTutorialHTML(Document doc);
}
