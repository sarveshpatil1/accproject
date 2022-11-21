package SearchEngine;

import java.util.Scanner;

public class MainSearchEngine {
	
	static int mainInput,input;
	static String url="";
	static Scanner read = new Scanner(System.in);
	
	public static void crawl(int input) {
		while(input!=0) {
			switch(input) {

			case 1:
				System.out.println("\nEnter the complete URL including https..:");
				url = read.next();
				System.out.println("\nPlease wait...\nCrwaling web pages...");
				Crawler.crawler(url);
				System.out.println("\nWeb pages crawled successfully!\n");
				break;
				
			case 2:
				for(String file: Crawler.fetchURLList())
					System.out.println(file);
				break;
				
			case 3:
				System.out.println("\n\n\t\t------------------------");
				System.out.println("\t\t|  S E A R C H  W O R D  |");
				System.out.println("\t\t------------------------");
				String wordToSearch= read.next();
				
				SearchWord.searchWord(wordToSearch);
				break;
				
			case 4:
				break;
				
			default:
				System.out.println("invalid input.. Please enter valid input..");
			}
			System.out.println("\n1. Crawl different pages\t2. Display all the crawled pages\t3. Search\t0. Exit");
			input = read.nextInt();
		}
		System.out.println("\nWeb Crawler closed!");
	}
	
	public static void main(String[] args) {
		System.out.println("\t\tW E B P A G E   S E A R C H  E N G I N E ");
		System.out.println("\t\t-----------------------------------------");
		System.out.println("\nSelect the option below:");
		System.out.println("\t1. Crawl Pages\n\t2. Search\n\t3. Exit");
		mainInput = read.nextInt();
		while(mainInput!=0) {
			switch(mainInput) {
			
			case 1:
				System.out.println("\n\t\t|  W E B  C R A W L E R  |");
				System.out.println("\t\t--------------------------");
				crawl(mainInput);
				break;
				
			case 2:
				System.out.println("\n\n\t\t  W O R D  S E A R C H  ");
				System.out.println("\t\t------------------------");
				System.out.println("\nEnter word:");
				String wordToSearch= read.next();
				SearchWord.searchWord(wordToSearch);
				System.out.println("\n1. Search Again\t\t0. Return to main menu");
				int in = read.nextInt();
				while(in!=0) {
					switch(in) {
					
					case 1: System.out.println("\nEnter word:");
					String wordtoSearch= read.next();
						SearchWord.searchWord(wordtoSearch);
						break;
						
						
					default:
						System.out.println("invalid input.. Please enter valid input..");
						
					}
					
					System.out.println("\n1. Search Again\t\t0. Return to main menu");
					in = read.nextInt();
				}
				System.out.println("Word Search closed!");
				break;
				
			default:
				System.out.println("invalid input.. Please enter valid input..");
			}
			System.out.println("\n1. Crawl Pages\t\t2. Search\t0. Exit");	
			mainInput = read.nextInt();
		}
		System.out.println("\nSearch Engine closed!");
	}
}
