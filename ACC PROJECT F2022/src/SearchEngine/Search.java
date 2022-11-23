package SearchEngine;

public class Search {
	public static int wordSearch(String data, String word, String fileName) {
		int counter = 0;
		int offset = 0;
		SearchEngine.BoyerMoore boyerMoore = new SearchEngine.BoyerMoore(word); //need boyer moore algorithm to perform search
		for (int location = 0; location <= data.length(); location += offset + word.length()) {
			offset = boyerMoore.search(word, data.substring(location));
			if ((offset + location) < data.length()) {
				counter++;
			}
		}
		if (counter != 0) {
			System.out.println("Found in HTML file --> " + fileName+" --> "+counter+" times"); // Founded from which HTML file..
			System.out.println("-------------------------------------------------------------------------");																								
		}
		return counter;
	}
}
