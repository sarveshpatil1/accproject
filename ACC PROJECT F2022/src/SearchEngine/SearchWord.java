package SearchEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
//import java.util.regex.Pattern;

public class SearchWord {
	private static Scanner sc = new Scanner(System.in);
	public static void searchWord(String wordToSearch) {

		HashMap<String, Integer> FileList = new HashMap<String, Integer>();
		int WordFrequency = 0;
		int TotFiles = 0,flag=0;
		FileList.clear();
		try {
			System.out.println("\nSearching...");
			File Files = new File("dat/HTML files/");
			//List all the files from the directory dat/HTML and creates an array of files
			File[] ArrayofFiles = Files.listFiles(); 

			for (File file: ArrayofFiles) {
				In data = new In(file.getAbsolutePath()); //gets the file path
				//For each file it reads all the data present in the file
				String txt = data.readAll(); 
				data.close();
				//Search the word and their frequency 
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

