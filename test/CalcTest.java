package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import challenge.Calc;

public class CalcTest {

	@Test
	public void shouldParseNumbers() {
		assertEquals(3, Calc.evaluate("3"), 0);
	}

	@Test
	public void shouldParseFloats() {
		assertEquals(3.5, Calc.evaluate("3.5"), 0);
	}

	@Test
	public void shouldSupportAddition() {
		assertEquals(4, Calc.evaluate("1 3 +"), 0);
	}

	@Test
	public void shouldSupportMultiplication() {
		assertEquals(3, Calc.evaluate("1 3 *"), 0);
	}

	@Test
	public void shouldSupportSubtraction() {
		assertEquals(-2, Calc.evaluate("1 3 -"), 0);
	}

	@Test
	public void shouldSupportDivision() {
		assertEquals(2, Calc.evaluate("4 2 /"), 0);
	}
}

