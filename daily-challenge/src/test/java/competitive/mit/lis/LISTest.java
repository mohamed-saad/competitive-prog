package competitive.mit.lis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.lis.LIS;
import competitive.mit.lis.LISImpl;


@RunWith(Parameterized.class)
public class LISTest {

	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] { new char[] { 'O', 'K', 'L', 'A', 'M', 'H', 'T', 'B' }, "KLMT" },
			new Object[] { new char[] { 'E', 'M', 'P', 'A', 'T', 'H', 'Y' }, "EMPTY" } ,	
		};
	}
	
	@Parameter(0)
	public char[] input;
	
	@Parameter(1)
	public String expected;
	
	private LIS implementation;
	
	@Before
	public void setup() {
		implementation = new LISImpl();
	}
	
	@Test
	public void test() {
		String actual = implementation.getLongestIncreasingSequence(input);
		Assert.assertEquals(expected, actual);
	}
	
}
