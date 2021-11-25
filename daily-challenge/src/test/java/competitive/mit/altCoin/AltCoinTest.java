package competitive.mit.altCoin;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.altCoin.AltCoin;
import competitive.mit.altCoin.AltCoinImpl1;
import competitive.mit.altCoin.AltCoinImpl2;

@RunWith(Parameterized.class)
public class AltCoinTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] { new int[] { 5, 25, 100, 10 }, new int[] { 5, 100 } },
			new Object[] { new int[] { 5, 25, 80, 20, 8, 100, 1, 10 }, new int[] { 5, 80, 10, 100} },
		};
	}
	
	@Parameter(0)
	public int[] coins;
	
	@Parameter(1)
	public int[] expected;
	
	private AltCoin implementation;
	
	@Before
	public void setup() {
		implementation = new AltCoinImpl1();
		implementation = new AltCoinImpl2();
	}
	
	@Test
	public void test() {
		List<Integer> actual = implementation.findBest(coins);
		for (int i=0; i<expected.length; i++) {
			Assert.assertTrue("coin" + expected[i] + " was not found", actual.contains(expected[i]));
		}
	}

}
