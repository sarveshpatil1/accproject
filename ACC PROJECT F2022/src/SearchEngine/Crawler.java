package SearchEngine;

/**
 * Crawler class
 * @author Sarvesh
 */
public class Crawler {
	
    /**
     * Constructor
     * @param url
     */
    public Crawler(String url) {   
    	UsingRegularExpression.getLinks(url);
        HTMLtoTEXT.htmlToText();
    }

    /**
     * Method- fetchURLList
     * this method fetches the list of URLs and
     * @return list of URLs of type string
     */
    public static String[] fetchURLList () {
        String[] listOfURL = UsingRegularExpression.linkList.toArray(new String[UsingRegularExpression.linkList.size()]);
        return listOfURL;
    }
    
    /**
     * Method- crawler
     * @param url
     */
    public static void crawler(String url) {
    	UsingRegularExpression.getLinks(url);
    	HTMLtoTEXT.htmlToText();
    }
}
