package SearchEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 -- 
 -- Class HTMLtoTEXT 
 -- @author DrashtiKoshti
 */
public class HTMLtoTEXT {

	/**1.0
	 -- Method name- fileConverter
	 -- 
	 -- @param htmlFile
	 -- @param textFile
	 --This method uses Jsoup to parse the html files and store it in document 
	 --This method converts from html format to txt and store the document as text document
	 --@throws Exception
	 */
	public static void fileConverter(String htmlFile, String textFile) {
		try {
		File HTMLFile = new File(htmlFile);
		Document document = Jsoup.parse(HTMLFile, "UTF-8");    
		String Text = document.text(); 
		BufferedWriter writeText = new BufferedWriter(new FileWriter(textFile)); 
		writeText.write(Text);
		writeText.close();
		}catch (Exception error)
		{
			System.out.println("URL cannot be fetched:"+error);
		}
	}
	
	/**2.0
	-- Method name- htmlFile
	--This method creates folder if not already created and stores all the crawled html files.
	-- @param hyperLink- crawled pages that are stored in array list.
	-- @return 
	-- @throws IOException
	 */
	public static void htmlFile(String link) throws IOException {
		Document urlLink = Jsoup.connect(link).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
				.referrer("http://www.google.com").ignoreHttpErrors(true).timeout(10*1000).get();
		String storeHTML = "dat/HTML files/";
		String html = urlLink.html();
		File htmlFolder = new File(storeHTML);
		if (!htmlFolder.exists() && !htmlFolder.isDirectory())
		{
			htmlFolder.mkdir();
		}  
		PrintWriter text = new PrintWriter(storeHTML + UsingRegularExpression.getLinkAddress(link) + ".html");
		text.println(html);
		text.close();
	}
	
	/**3.0
	 -- Method name- textFile
	 --In this method, same name .txt files are created which are there in html file folder
	 -- and then fileConverter method is called to convert hmtl content to text
	 -- @param link
	 -- @throws IOException
	 
	 */
	public static void textFile(String link) throws IOException {
		String storeText = "dat/Text Files/";
		File textFolder = new File(storeText);
		if (!textFolder.exists() && !textFolder.isDirectory()) {
			textFolder.mkdir();
		}   
		File folder = new File("dat/HTML files/");
		File[] fileStream = folder.listFiles();
		assert fileStream != null;
		
		for (File file : fileStream) {  
			String htmlFile = "dat/HTML files/" + file.getName();
			String textFile = storeText + file.getName().replaceAll(".htm", "") + ".txt";
			fileConverter(htmlFile,textFile);
			}
		}
		
    /**4.0
     -- Method name- htmlToText 
     --This method performs the crawl functionality   
     */
	public static void htmlToText() {
		try {
			for (String link : UsingRegularExpression.linkList) {
				htmlFile(link);
				textFile(link);
			}
		} catch (Exception error) {

			System.out.println("URL cannot be fetched:"+error);
		} 
	}
}
