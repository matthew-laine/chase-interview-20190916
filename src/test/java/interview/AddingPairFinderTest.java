package interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class AddingPairFinderTest {
	
	int[] oneTwo = {1,2};
	
	AddingPairFinder underTest;
	
	@Before
	public void setup () {
		underTest = new AddingPairFinder();
	}
	
	@Test
	public void oneAndTwoShouldNotAddUpToFourInsteadShouldReturnNegOneNegOne () {
		int[] pair = underTest.getPair(oneTwo, 4);
		assertThat(pair[0], is(-1));
		assertThat(pair[1], is(-1));
	}
	
	@Test
	public void oneAndTwoShouldAddUpToThreeShouldReturnZeroOne () {
		int[] pair = underTest.getPair(oneTwo, 3);
		assertThat(pair[0], is(0));
		assertThat(pair[1], is(1));
	}
}
