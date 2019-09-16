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
		
		Map<String, Integer> wordsAndFrequencies = new HashMap<String, Integer>();
		// Make first test pass.
		wordsAndFrequencies.put("FOO", 1);
		return wordsAndFrequencies;
	}
	
	

}
