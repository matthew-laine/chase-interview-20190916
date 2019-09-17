package interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {

	WordCounter underTest;
	Map<String, Integer> frequencies;

	@Before
	public void setup() {
		underTest = new WordCounter();
	}

	@Test
	public void countWordFrequencyOfFooShouldReturnFoo1() {
		frequencies = underTest.countWordFrequency("Foo");
		assertThat(frequencies.get("FOO"), is(1));
	}

	@Test
	public void countWordFrequencyOfFooBarShouldReturnMapContainingFoo1AndBar1() {
		frequencies = underTest.countWordFrequency("Foo Bar");
		assertThat(frequencies.get("FOO"), is(1));
		assertThat(frequencies.get("BAR"), is(1));
	}

	@Test
	public void countWordFrequencyOfFooBarFooFooBarShouldReturnMapContainingFoo3AndBar2() {
		frequencies = underTest.countWordFrequency("Foo Bar foo FOO bar");
		assertThat(frequencies.get("FOO"), is(3));
		assertThat(frequencies.get("BAR"), is(2));
	}

	@Test
	public void countWordFrequencyOfTheseAreTheTimeThatTryMensSoulsOfSoulsShouldBe1AndSoulsPeriodShouldBeZero() {
		frequencies = underTest.countWordFrequency("These   are the times that try men's souls.");
		assertThat(frequencies.get("SOULS"), is(1));
		assertThat(frequencies.containsKey("SOULS."), is(false));
		assertThat(frequencies.containsKey(" "), is(false));
	}
}