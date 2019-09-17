package interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class AddingPairFinderTest {
	
	int[] oneTwo = {1,2};
	
	@Test
	public void oneAndTwoShouldNotAddUpToFourInsteadShouldReturnNegOneNegOne () {
		AddingPairFinder underTest = new AddingPairFinder();
		int[] pair = underTest.getPair(oneTwo, 4);
		assertThat(pair[0], is(-1));
		assertThat(pair[1], is(-1));
	}

}
