package interview;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		WordCounter parser = new WordCounter();
		System.out.println(
				parser.countWordFrequency("Happy days are here again. Happy happy happy. Why are happy days here?"));

		AddingPairFinder finder = new AddingPairFinder();
		int[] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		List<int[]> pairsThatSumTo100 = finder.getPairs(numbers, 100);
		for (int i = 0; i < pairsThatSumTo100.size(); i++) {
			int[] pair = pairsThatSumTo100.get(i);
			System.out.println(pair[0] + ", " + pair[1]);			
		}
	}
}