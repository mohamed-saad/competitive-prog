package competitive.mit.parenthesization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.parenthesization.MaxParenthes;
import competitive.mit.parenthesization.MaxParenthesImpl;


@RunWith(Parameterized.class)
public class MaxParenthesTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] {
				new char[] { '4', '+', '7', '*', '3', '+', '5' }, 
				88
			},
			new Object[] {
				new char[] { '4', '+', '7', '*', '3', '+', '5', '*', '8', '*', '3' }, 
				2112
			},
		};
	}
	
	@Parameter(0)
	public char[] equation;
	
	@Parameter(1)
	public int expected;
	
	private MaxParenthes implementation;
	
	@Before
	public void setup() {
		implementation = new MaxParenthesImpl();
	}
	
	@Test
	public void test() {
		int actual = implementation.evaluate(equation);
		Assert.assertEquals(expected, actual);
	}

	
}
