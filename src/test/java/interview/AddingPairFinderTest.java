package interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AddingPairFinderTest {

	int[] oneTwo = { 1, 2 };
	int[] oneThruFive = { 1, 2, 3, 4, 5 };

	AddingPairFinder underTest;

	@Before
	public void setup() {
		underTest = new AddingPairFinder();
	}

	@Test
	public void oneAndTwoShouldNotAddUpToFourInsteadShouldReturnNegOneNegOne() {
		List<int[]> pairs = underTest.getPairs(oneTwo, 4);
		assertThatPairContainsValues(pairs, 0, -1, -1);		
	}

	@Test
	public void oneAndTwoShouldAddUpToThreeShouldReturnZeroOne() {
		List<int[]> pairs = underTest.getPairs(oneTwo, 3);
		assertThatPairContainsValues(pairs, 0, 0, 1);
	}

	@Test
	public void oneTwoThreeFourFiveShouldGiveTwoPairsThatAddUpToSix() {
		List<int[]> pairs = underTest.getPairs(oneThruFive, 6);
		/*
		 * The reason these assertions are ordered the way they are is that the first
		 * pair {1,3} will be made when you hit element 3 of the array, and the second
		 * pair {2,4} will be made when you hit element 4 of the array.
		 */
		assertThatPairContainsValues(pairs, 0, 1, 3);
		assertThatPairContainsValues(pairs, 1, 0, 4);

	}
	
	// Extract method to make writing assertions easier
	// Checks to see whether an int[] pair at certain index of list contains value0 and value1
	private void assertThatPairContainsValues(List<int[]> pairs, int index, int value0, int value1) {
		assertThat(pairs.get(index)[0], is(value0));
		assertThat(pairs.get(index)[1], is(value1));
	}
}
