package interview;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	public Map<String, Integer> countWordFrequency(String input) {
		
		String[] allWordsInOrder = capitalizeAndSplit(input);
		
		Map<String, Integer> wordsAndFrequencies = new HashMap<String, Integer>();
		
		for (String word : allWordsInOrder) {
			if (hashMapAlreadyContainsWord(wordsAndFrequencies, word)) {
				incrementWordCount(wordsAndFrequencies, word);
			}
			if (!hashMapAlreadyContainsWord(wordsAndFrequencies, word)) {
				wordsAndFrequencies.put(word, 1);
			}
		}
		return wordsAndFrequencies;
	}

	private void incrementWordCount(Map<String, Integer> wordsAndFrequencies, String word) {
		Integer count = wordsAndFrequencies.get(word);
		wordsAndFrequencies.replace(word, count, ++count);
	}

	private boolean hashMapAlreadyContainsWord(Map<String, Integer> wordsAndFrequencies, String word) {
		return wordsAndFrequencies.containsKey(word);
	}

	private String[] capitalizeAndSplit(String input) {
		String capitalized = input.toUpperCase();
		String[] words = capitalized.split("([.,!?:;'\"-]|\\s)+");
		return words;
	}

}
