package SearchEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 -- 
 -- UsingRegularExpression class
 -- methods in this class:getLinks, getLinks
 -- @author  DrashtiKoshti
 */

public class UsingRegularExpression {
	
	public static ArrayList<String> linkList = new ArrayList<>();
	
    /**
     --1.0
     -- Method- getLink
     --This method stores links into linkList.
     -- @param url
     */
	
    public static void getLinks(String webaddress) {
        Document htmlPage;
        try {
        	htmlPage = Jsoup.connect(webaddress).get();
            Elements path = htmlPage.select("a[href]");
            for (Element link : path) {
            	
                String abst_URL = link.attr("abs:href");
                String regexpression = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
                Pattern url_Pattrn = Pattern.compile(regexpression);
                Matcher match_URL = url_Pattrn.matcher(abst_URL);
                while (match_URL.find()) {
                    linkList.add(match_URL.group(0));
                }
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    
    /**
     --2.0
     --Method name - getLinkAddress
     -- @param link
     -- @return
     */
    public static String getLinkAddress(String webaddress) {
    	String regexpression = "[a-zA-Z0-9]+";
		Pattern Pattern_link = Pattern.compile(regexpression);
		Matcher Link_match = Pattern_link.matcher(webaddress);
		StringBuffer string = new StringBuffer();
		while (Link_match.find()) {
			string.append(Link_match.group(0));
		}
		String link_Adress = string.substring(0);
		return link_Adress;
    }

}
