/**
 * This program will translate acronyms that are pulled from a text file in a sentence
 * 
 * Dustin Wleczyk
 * LSU ID: 89-188-8894
 * LAB TA: Mikayla
 * 
 * 
 * @source 3/24/21
 * @author dustin251
 *
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class YoMommaTranslator {
	
	public static void readFile(Map<String, String> acronym) {
		
		try {
			
			File file = new File("acronyms.txt");
			
			Scanner readTheFile = new Scanner(file);
			
			while (readTheFile.hasNextLine()) {
				
				String[] split = readTheFile.nextLine().split("\\t");
				
				acronym.put(split[0], split[1]);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e);
			
		}
		
	}
	
	public static void changeElement(String[] sentence, String meaning, String key) {
		
		for (int i = 0; i < sentence.length; i++) {
			
			if (sentence[i].toLowerCase().equals(key.toLowerCase())) {
				
				sentence[i] = meaning.toLowerCase();
			}
		
		}
	}
	
	

	public static void main(String[] args) {
		
		
		
		Map<String, String> acronyms = new HashMap<String, String>();
		
		readFile(acronyms);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input a sentence with the acronyms that will be translated.");
		
		String userSayWhat = "";
		
		userSayWhat = input.nextLine();
		
		String[] split = userSayWhat.split("\\s+");
		
		
		for (String element: split) {
			
			for (Map.Entry<String, String> key: acronyms.entrySet()) {
				
				if (element.toLowerCase().equals(key.getKey().toLowerCase())){
					String meaning = key.getValue();
					
					changeElement(split, meaning.toLowerCase(), key.getKey().toLowerCase());
					
				}
			}
		}
		
		for (String element: split) {
			System.out.print(element + " ");
		}
		
		

	}

}
