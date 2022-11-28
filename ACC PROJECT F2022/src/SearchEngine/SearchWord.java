package SearchEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
//import java.util.regex.Pattern;

public class SearchWord {
	private static Scanner sc = new Scanner(System.in);
	//public static String htmlDirectoryPath = "dat/HTML files/";
	//public static String txtDirectoryPath = "dat/Text Files/";
	public static void searchWord(String wordToSearch) {

		HashMap<String, Integer> FileList = new HashMap<String, Integer>();

//		System.out.println("\nEnter word:");
//		String wordToSearch= sc.next();

		int WordFrequency = 0;
		int TotFiles = 0,flag=0;
		FileList.clear();
		try {
			System.out.println("\nSearching...");
			File Files = new File("dat/HTML files/");

			File[] ArrayofFiles = Files.listFiles(); //create an array for filenames

			for (File file: ArrayofFiles) {
				In data = new In(file.getAbsolutePath()); //gets the file path
				String txt = data.readAll(); //read all lines from the file
				data.close();
				//Pattern p = Pattern.compile("::");
				//String[] file_name = p.split(txt);S
				WordFrequency = Search.wordSearch(txt, wordToSearch.toLowerCase(), file.getName());

				if (WordFrequency != 0) {
					FileList.put(file.getName(), WordFrequency); //hashtable for each file name with its word count
					TotFiles++;
				}	
			}
			if(TotFiles>0) {
				System.out.println("\nTotal number of pages containing word : " + wordToSearch + " is : " + TotFiles);
			}else {
				System.out.println("\npages not found!\n word searched: "+ wordToSearch);
				System.out.println("\nChecking alternate words.....\n");
				PredictWord.suggestAlternativeWord(wordToSearch.toLowerCase());
				flag=1;
			}
			if(flag!=1)
			RankPages.rankFiles(FileList, TotFiles,wordToSearch); 				   


		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}

