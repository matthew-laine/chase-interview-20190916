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
		assertThat(pairs.get(0)[0], is(-1));
		assertThat(pairs.get(0)[1], is(-1));
	}

	@Test
	public void oneAndTwoShouldAddUpToThreeShouldReturnZeroOne() {
		List<int[]> pairs = underTest.getPairs(oneTwo, 3);
		assertThat(pairs.get(0)[0], is(0));
		assertThat(pairs.get(0)[1], is(1));
	}

	@Test
	public void oneTwoThreeFourFiveShouldGiveTwoPairsThatAddUpToSix() {
		List<int[]> pairs = underTest.getPairs(oneThruFive, 6);
		/*
		 * The reason these assertions are ordered the way they are is that the first
		 * pair {1,3} will be made when you hit element 3 of the array, and the second
		 * pair {2,4} will be made when you hit element 4 of the array.
		 */
		assertThat(pairs.get(0)[0], is(1));
		assertThat(pairs.get(0)[1], is(3));
		assertThat(pairs.get(1)[0], is(0));
		assertThat(pairs.get(1)[1], is(4));

	}
}
