package competitive.mit.subsetSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.subsetSum.SubsetSum;
import competitive.mit.subsetSum.SubsetSumImpl2;

@RunWith(Parameterized.class)
public class SubsetSumTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
				new Object[] {
						new Integer[] { 12, 1, 4, 7, 9, 3, 8 },
						16,
						true
				},
				new Object[] {
						new Integer[] { 12, 1, 4, 7, 9, 3, 8 },
						38,
						false
				},
				new Object[] {
						new Integer[] { 12, 1, 4, 7, 9, 3, 8 },
						6,
						false
				}
		};
	}
	
	@Parameter(0)
	public Integer[] set;
	
	@Parameter(1)
	public Integer targetSum;
	
	@Parameter(2)
	public boolean expected;
	
	private SubsetSum implementation;
	
	@Before
	public void setup() {
//		implementation = new SubsetSumImpl();
		implementation = new SubsetSumImpl2();
	}
	
	@Test
	public void test() {
		Set<Integer> input = new HashSet<>();
		input.addAll(Arrays.asList(set));
		boolean actual = implementation.subsetSum(input, targetSum);
		Assert.assertEquals(expected, actual);
	}

}
