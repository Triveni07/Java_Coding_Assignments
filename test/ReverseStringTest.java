package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import practice.ReverseString;

class ReverseStringTest {

	@Test	
	public  void shouldReverseString() {
	assertEquals("here am I", ReverseString.reverseString("I am here"));
	}
	@Test
	public void shouldReverseCharacters() {
		assertEquals(".eciffo ot gniog ma I", ReverseString.reverseCharacters("I am going to office."));
	}
	@Test
	public void shouldReverseAlternateCharacters() {
		assertEquals("Mi eaieTis  rmvnny", ReverseString.reverseAlternateChars("My name is Triveni"));
	}

}
