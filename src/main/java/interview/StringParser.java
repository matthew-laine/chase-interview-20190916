package interview;

import java.util.HashMap;
import java.util.Map;

public class StringParser {

	public Map<String, Integer> countWordFrequency(String string) {
		/*
		 * The basic idea here is going to be using a HashMap to do the work
		 * If we wanted this to be sortable, we could use a TreeMap and it would
		 * sort (and do other things) in O(logN) time, but for the purpose of not 
		 * having it sorted, a HashMap would be faster as accessing entries 
		 * will be done in Theta(1) time. 
		 */
		
		
		// Capitalize String and split with space as delimiter
		// Needed to make second test pass
		String capitalized = string.toUpperCase();
		String[] words = capitalized.split(" ");
		
		Map<String, Integer> wordsAndFrequencies = new HashMap<String, Integer>();
		
		// Write enough code to get second test to pass
		for (String word : words) {
			wordsAndFrequencies.put(word, 1);
		}
		return wordsAndFrequencies;
	}
	
	

}
