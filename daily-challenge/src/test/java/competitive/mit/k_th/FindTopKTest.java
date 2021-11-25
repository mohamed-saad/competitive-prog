package competitive.mit.k_th;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.k_th.FindTopK;
import competitive.mit.k_th.FindTopKImpl2;

@RunWith(Parameterized.class)
public class FindTopKTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
				new Object[] {
						new Integer[] { 12, 34, 3, 1, 8, 100, 2, 1000, 33, 11, -9, 80, 50 },
						new Integer[] { 50, 80, 100, 1000 },
						true
				},
				new Object[] {
						new Integer[] { 12, 34, 3, 1, 8, 100, 2, 1000, 33, 11, -9, 80, 50 },
						new Integer[] { 3, 2, 1, -9 },
						false
				}
		};
	}
	
	@Parameter(0)
	public Integer[] numbers;
	
	@Parameter(1)
	public Integer[] expecteds;
	
	@Parameter(2)
	public boolean top;
	
	private FindTopK implementation;
	
	@Before
	public void setup() {
//		implementation = new FindTopKImpl();
		implementation = new FindTopKImpl2();
	}
	
	@Test
	public void test() {
		Integer[] actuals = implementation.topK(Arrays.asList(numbers), expecteds.length, top);
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
