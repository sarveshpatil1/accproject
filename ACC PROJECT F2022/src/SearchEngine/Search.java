package SearchEngine;

public class Search {
	public static int wordSearch(String data, String word, String fileName) {
		int counter = 0;
		int offset = 0;
		SearchEngine.BoyerMoore boyerMoore = new SearchEngine.BoyerMoore(word); //Implemented boyer moore algorithm to perform search
		for (int location = 0; location <= data.length(); location += offset + word.length()) {
			//Takes the offest of the word when the pattern is matched with the text
			offset = boyerMoore.search(word, data.substring(location));
			//Increments the count each time when the pattern is found in the file
			if ((offset + location) < data.length()) {
				counter++;
			}
		}
		if (counter != 0) {
			System.out.println("Found in page --> " + fileName+" --> "+counter+" times"); // Founded from which HTML file..
			System.out.println("______________________________________________________________");																								
		}
		return counter;
	}
}
