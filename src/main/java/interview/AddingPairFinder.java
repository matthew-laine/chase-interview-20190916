package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddingPairFinder {

	/*
	 * The getPair method returns the indices of two integers from an array that add
	 * up to the target sum. If no such numbers exist, then the return is {-1, -1}.
	 */
	public int[] getPair(int[] input, int targetSum) {
		/*
		 * Here, the idea is to find a data structure that will quickly allow us to
		 * determine whether a certain number in our array has a pair. We do this by
		 * making a HashMap of numbers needed to add to each array element to reach the
		 * target sum. We can then quickly access the HashMap to see whether we have a
		 * match as we iterate through the array.
		 */
		int[] pairDoesNotExist = { -1, -1 };

		Map<Integer, Integer> neededNumbers = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			if (numberComplementsAPreviousNumber(input, i, neededNumbers)) {
				int[] numberPair = makeNumberPair(input, i, neededNumbers);
				return numberPair;
			} 
			if (!numberComplementsAPreviousNumber(input, i, neededNumbers)){
				neededNumbers.put(targetSum - input[i], i);
			}
		}
		return pairDoesNotExist;
	}

	/*
	 * Here, the idea is to return a list of all the indices of the pairs of numbers
	 * that add up to the target sum. We will add the pairs to a list rather than
	 * having a return statement within the loop as done in our previous method.
	 */
	public List<int[]> getPairs(int[] input, int targetSum) {

		int[] pairDoesNotExist = { -1, -1 };

		Map<Integer, Integer> neededNumbers = new HashMap<Integer, Integer>();
		List<int[]> pairs = new ArrayList<int[]>();

		for (int i = 0; i < input.length; i++) {
			if (numberComplementsAPreviousNumber(input, i, neededNumbers)) {
				int[] numberPair = makeNumberPair(input, i, neededNumbers);
				pairs.add(numberPair);
			} 
			if (!numberComplementsAPreviousNumber(input, i, neededNumbers)) {
				neededNumbers.put(targetSum - input[i], i);
			}
		}
		if (pairs.size() == 0) {
			pairs.add(pairDoesNotExist);
		}
		return pairs;
	}

	private int[] makeNumberPair(int[] input, int i, Map<Integer, Integer> neededNumbers) {
		int[] numberPair = { neededNumbers.get(input[i]), i };
		return numberPair;
	}

	private boolean numberComplementsAPreviousNumber(int[] input, int i, Map<Integer, Integer> neededNumbers) {
		return neededNumbers.containsKey(input[i]);
	}

}
