package SearchEngine;

/**
 ---------- Crawler class-----------
 ---------- @author DrashtiKoshti
  */

public class Crawler {
	
    /**
     Constructor @param url
     */
    public Crawler(String webaddress) {   
    	UsingRegularExpression.getLinks(webaddress);
        HTMLtoTEXT.htmlToText();
    }

    /**
     -- Method name - fetchURLList
     -- this method retrieves a list of URLs and 
     -- @return list of URLs of type string
     */
    public static String[] fetchURLList () {
        String[] listOfURL = UsingRegularExpression.linkList.toArray(new String[UsingRegularExpression.linkList.size()]);
        return listOfURL;
    }
    
    /**
     -- Method name - crawler
     -- @param url
     */
    public static void crawler(String webaddress) {
    	UsingRegularExpression.getLinks(webaddress);
    	HTMLtoTEXT.htmlToText();
    }
}
