package interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class StringParserTest {
	/*
	 * The StringParser will have a method called countWordFrequency
	 * The countWordFrequency method will return all the words 
	 * (delimited by a space) in the string and their frequencies
	 *
	 * All returned words should be capitalized so that the words
	 * "the" "thE" "tHe" "tHE" "The" "ThE" "THe" and "THE"
	 * are all evaluated as "THE"
	 */
	
	StringParser underTest;
	Map<String, Integer> frequencies;
	@Before
	public void setup () {
		underTest = new StringParser();
	}
	
	@Test
	public void countWordFrequencyOfFooShouldReturnFoo1 () {
		/*
		 * The basic idea here is to insert or modify a Key/Value pair
		 * with the key being every unique capitalized word in the string
		 * and the value being its frequency.
		 */
		frequencies = underTest.countWordFrequency("Foo");
		assertThat(frequencies.get("FOO"), is(1));
	}
	
	@Test
	public void countWordFrequencyOfFooBarShouldReturnMapContainingFoo1AndBar1 () {
		frequencies = underTest.countWordFrequency("Foo Bar");
		assertThat(frequencies.get("FOO"), is(1));
		assertThat(frequencies.get("BAR"), is(1));
	}
	
	@Test
	public void countWordFrequencyOfFooBarFooFooBarShouldReturnMapContainingFoo3AndBar2 () {
		frequencies = underTest.countWordFrequency("Foo Bar foo FOO bar");
		assertThat(frequencies.get("FOO"), is(3));
		assertThat(frequencies.get("BAR"), is(2));
	}
}