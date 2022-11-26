package SearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredictWord {

	public static String htmlDirectoryPath = "dat/HTML files/";
	public static String txtDirectoryPath = "dat/Text Files/";
	static HashMap<String, Integer> numbers = new HashMap<String, Integer>();
	static ArrayList<String> key = new ArrayList<String>();
	
	public static void suggestAltWord(String wordToSearch) {
		String line = " ";
		String regex = "[a-z0-9]+";
		Pattern pattern = Pattern.compile(regex); //initialize the regex in pattern to reuse
		Matcher matcher = pattern.matcher(line);
		

		File dir = new File(txtDirectoryPath); //read the text files in a
		File[] fileArray = dir.listFiles(); //put the files name in an array
		for (File file: fileArray) {
			try {
				findWord(file, matcher, wordToSearch); //find
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		Integer allowedDistance = 1; 
		boolean matchFound = false; 
		int i = 0;
		for (@SuppressWarnings("rawtypes") Map.Entry entry : numbers.entrySet()) {
			if (allowedDistance == entry.getValue()) {
				i++;
				if(i==1)
				System.out.println("Wrong word searched..\nYou might have mispelled, Try .. ");
				System.out.print(i + ". " + entry.getKey() + "\n");
				matchFound = true;
			}
		}
		if(matchFound) {

			System.out.println("Please search again with correct words \n ");

		}
		
		if (!matchFound)
			System.out.println("Entered word cannot be resolved....");
		
	}

	
	public static void findWord(File sourceFile, Matcher match, String str)
			throws FileNotFoundException, ArrayIndexOutOfBoundsException {
		try {
			BufferedReader my_rederObject = new BufferedReader(new FileReader(sourceFile));
			String line = null;

			while ((line = my_rederObject.readLine()) != null) {
				match.reset(line);
				while (match.find()) {
					key.add(match.group());
				}
			}

			my_rederObject.close();
			for (int p = 0; p < key.size(); p++) {
				numbers.put(key.get(p), EditDistance.editDistance(str.toLowerCase(), key.get(p).toLowerCase()));
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

	}
}
