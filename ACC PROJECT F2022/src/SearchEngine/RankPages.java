package SearchEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class RankPages {
	static Scanner sc = new Scanner(System.in);
/**
 *displays the top pages where word is repeated maximum or minimum number of times
 *@param files :hashmap of files containing filenames and word occurance
 *@param occur :number of files where word is found
 *@param word :that is searched
 *
 *
 */
	public static void rankFiles(HashMap<?, Integer> files, int occur,String word) {

		ArrayList<Map.Entry<?, Integer>> fileList = new ArrayList<Map.Entry<?, Integer>>(files.entrySet()); //new list to store files
		//values in hashmap can be accessed by map.entry inteface
		//entryset is a function that returns all the key value pairs
		
		Collections.sort(fileList, new Comparator<Map.Entry<?, Integer>>() {
			public int compare(Map.Entry<?, Integer> obj1, Map.Entry<?, Integer> obj2) { 
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		
		System.out.println("\n Would you like to check pages where word is found max or min number of times?\n\tChoose\n\t1. to display links where word is repeated maximum times"+ "\n\t2. to display links where word is repeated Minimum number of times\n\t3. exit");
		int choice=sc.nextInt();
		
		if(choice==1) {
		Collections.reverse(fileList);

		if (occur != 0) {
			if(occur > 10)
				System.out.println("\n------  10 pages where word \""+word+"\" is repeated maximum number of times ------");
			else
				System.out.println("\n------ Top "+occur+" search results ------");

			int noOfFiles = 10;
			int j = 0;
			int i=1;
			while (fileList.size() > j && noOfFiles > 0) {
				
				if(fileList.get(j).getKey()!=null) {
				System.out.println("(" + i + ") " + fileList.get(j).getKey()+"=> "+fileList.get(j).getValue()+" Times"); //display the file and number of times word occured in that file
				j++;
				i++;
				}
				noOfFiles--;
				
			}
		} 
	}
		else if(choice==2) {
			if (occur != 0) {
				if(occur > 10)
					System.out.println("\n------  10 pages where word \""+word+"\" is found minimum number of times ------");
				else
					System.out.println("\n------ Top "+occur+" search results ------");

				int noOfFiles = 10;
				int j = 0;
				int i=1;
				while (fileList.size() > j && noOfFiles > 0) {
					
					
					if(fileList.get(j).getKey()!=null) {
					System.out.println("(" + i + ") " + fileList.get(j).getKey()+"=> "+fileList.get(j).getValue()+" Times"); //display the file and number of times word occured in that file
					j++;
					i++;
					}
					noOfFiles--;
					
				}
			}			
		}
		else
			System.out.println("\n");
	
}
}
