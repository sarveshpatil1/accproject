package SearchEngine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;


public class RepeatWord {


		public static void repeatedWord(String textFile) throws IOException {
			String line;
			String word = "";
			int count =0, maxCount=0;
			ArrayList<String> words = new ArrayList<String>();
			File file3 = new File(textFile);
			//Taking the absolute path of the file
			In data = new In(file3.getAbsolutePath());
			//Read the contents of the file
			String txt = data.readAll();
			//Converts all the contents to the lowercase
	 String string[] = txt.toLowerCase().split("\\s+");
	 for(String s : string) {
		 //Adds each word to the array
		 words.add(s);
	 }
 for(int i=0;i<words.size();i++) {
	 count =0;
	 for(int j= i; j<words.size();j++) { 
		 //Checks whether the words are equal
		 if(words.get(i).equals(words.get(j))) {
			 //If the word is matching then increments the count
			 count++;
		 }
		 
	 }
	 if(count>maxCount) {
			maxCount =count;
			//Takes the word which has maxCount
			word = words.get(i);
		 }
}
 System.out.println("The most repeated word is '"+word+"' has occured "+maxCount+ " times in the file " +textFile.substring(15));
		}
}

