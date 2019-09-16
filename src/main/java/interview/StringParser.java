package interview;

import java.util.HashMap;
import java.util.Map;

public class StringParser {

	public Map<String, Integer> countWordFrequency(String string) {
		/*
		 * The basic idea here is going to be using a HashMap to do the work If we
		 * wanted this to be sortable, we could use a TreeMap and it would sort (and do
		 * other things) in O(logN) time, but for the purpose of not having it sorted, a
		 * HashMap would be faster as accessing entries will be done in Theta(1) time.
		 */

		String[] words = capitalizeAndSplit(string);

		Map<String, Integer> wordsAndFrequencies = new HashMap<String, Integer>();

		// Write enough code to get third test to pass
		// Here, we need to increment the count if the word is in map
		// and add the key with count 1 if the word is not in map
		for (String word : words) {
			if (wordsAndFrequencies.containsKey(word)) {
				Integer count = wordsAndFrequencies.get(word);
				wordsAndFrequencies.replace(word, count, ++count);
			}
			if (!wordsAndFrequencies.containsKey(word)) {
				wordsAndFrequencies.put(word, 1);
			}
		}
		return wordsAndFrequencies;
	}

	private String[] capitalizeAndSplit(String string) {
		// Capitalize String and split with space as delimiter
		String capitalized = string.toUpperCase();
		String[] words = capitalized.split(" ");
		return words;
	}

}
