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
    public static void getLinks(String url) {
        Document page;
        try {
            page = Jsoup.connect(url).get();
            Elements links = page.select("a[href]");
            for (Element link : links) {
            	
                String absURL = link.attr("abs:href");
                String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
                Pattern urlPattern = Pattern.compile(regex);
                Matcher matchURL = urlPattern.matcher(absURL);
                while (matchURL.find()) {
                    linkList.add(matchURL.group(0));
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
    public static String getLinkAddress(String link) {
    	String regex = "[a-zA-Z0-9]+";
		Pattern linkPattern = Pattern.compile(regex);
		Matcher matchLink = linkPattern.matcher(link);
		StringBuffer string = new StringBuffer();
		while (matchLink.find()) {
			string.append(matchLink.group(0));
		}
		String linkAdress = string.substring(0);
		return linkAdress;
    }

}
