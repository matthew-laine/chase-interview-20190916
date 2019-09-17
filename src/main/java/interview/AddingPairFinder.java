package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddingPairFinder {

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
