package competitive.mit.lcs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.lcs.LCS;
import competitive.mit.lcs.LCSImpl;

@RunWith(Parameterized.class)
public class LCSTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] { new char[] {'A', 'K', 'L', 'O', 'B' }, new char[] {'M', 'K', 'I', 'O', 'A' }, "KO" },
			new Object[] { new char[] {'A', 'K', 'L', 'O', 'B' }, new char[] {'A', 'L', 'I', 'O', 'A', 'B', 'N' }, "ALOB" },
		};
	}
	
	@Parameter(0)
	public char[] a;
	
	@Parameter(1)
	public char[] b;
	
	@Parameter(2)
	public String expected;
	
	private LCS implementation;
	
	@Before
	public void setup() {
		implementation = new LCSImpl();
	}
	
	@Test
	public void test() {
		String actual = implementation.getLongestCommonSequence(a, b);
		Assert.assertEquals(expected, actual);
	}

}
