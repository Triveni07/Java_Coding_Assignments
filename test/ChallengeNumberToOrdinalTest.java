package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import challenge.ChallengeNumberToOrdinal;

import static org.junit.Assert.assertEquals;

public class ChallengeNumberToOrdinalTest {
	@Test
	public void shouldHandleSingleDigits() {
		assertEquals("0", ChallengeNumberToOrdinal.numberToOrdinal(0));	        
		assertEquals("1st", ChallengeNumberToOrdinal.numberToOrdinal(1));
		assertEquals("2nd", ChallengeNumberToOrdinal.numberToOrdinal(2));
		assertEquals("3rd", ChallengeNumberToOrdinal.numberToOrdinal(3));
		assertEquals("4th", ChallengeNumberToOrdinal.numberToOrdinal(4));
	}

	@Test
	public void shouldHandleDoubleDigits() {
		assertEquals("11th", ChallengeNumberToOrdinal.numberToOrdinal(11));
		assertEquals("12th", ChallengeNumberToOrdinal.numberToOrdinal(12));
		assertEquals("13th", ChallengeNumberToOrdinal.numberToOrdinal(13));

	}
	@Test
	public void shouldHandleTripleDigits() {
		assertEquals("111th", ChallengeNumberToOrdinal.numberToOrdinal(111));
		assertEquals("101st", ChallengeNumberToOrdinal.numberToOrdinal(101));
	}

}