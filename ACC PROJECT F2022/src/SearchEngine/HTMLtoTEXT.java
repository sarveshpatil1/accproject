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
	public static void fileConverter(String file_html, String file_text) {
		try {
		File file_HTML = new File(file_html);
		Document doc = Jsoup.parse(file_HTML, "UTF-8");    
		String txt = doc.text(); 
		BufferedWriter text_write = new BufferedWriter(new FileWriter(file_text)); 
		text_write.write(txt);
		text_write.close();
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
		Document link_url = Jsoup.connect(link).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
				.referrer("http://www.google.com").ignoreHttpErrors(true).timeout(10*1000).get();
		String HTML_store = "dat/HTML files/";
		String html = link_url.html();
		File folder_html = new File(HTML_store);
		if (!folder_html.exists() && !folder_html.isDirectory())
		{
			folder_html.mkdir();
		}  
		PrintWriter text = new PrintWriter(HTML_store + UsingRegularExpression.getLinkAddress(link) + ".html");
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
		String store_Text = "dat/Text Files/";
		File folder_text = new File(store_Text);
		if (!folder_text.exists() && !folder_text.isDirectory()) {
			folder_text.mkdir();
		}   
		File folder_new = new File("dat/HTML files/");
		File[] file_stream = folder_new.listFiles();
		assert file_stream != null;
		
		for (File file : file_stream) {  
			String file_html = "dat/HTML files/" + file.getName();
			String file_text = store_Text + file.getName().replaceAll(".htm", "") + ".txt";
			fileConverter(file_html,file_text);
			}
		}
		
    /**4.0
     -- Method name- htmlToText 
     --This method performs the crawl functionality   
     */
	public static void htmlToText() {
		try {
			for (String url : UsingRegularExpression.linkList) {
				htmlFile(url);
				textFile(url);
			}
		} catch (Exception error) {

			System.out.println("URL cannot be fetched:"+error);
		} 
	}
}
