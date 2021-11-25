package competitive.mit.heap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.heap.Heap;
import competitive.mit.heap.IHeap;

@RunWith(Parameterized.class)
public class HeapTest {
	
	public static int MAX = 10;
	
	@Parameters
	public static Object[] getParameters() {
		return new Object[] {
				 new int[] { 10, 40, 8, 50, 1, 100 },
				 new int[] { 100, 90, 80, 70, 60, 50 },
				 new int[] { 100 },
				 new int[] { -10, -40, -8, -50, -1, -100 },
				 new int[] { 100, 90, 80, 50, 70, 60, 50 },
		};
	}
	

	@Parameter(0)
	public int test[];
	
	private IHeap implementation;
	
	@Before
	public void setup() {
		implementation = new Heap(MAX);
	}
	
	@Test
	public void testOrder() {
		for (int i: test) implementation.add(i);
		Arrays.sort(test);
		for (int expected: test) {
			int actual = implementation.getMin();
			Assert.assertEquals("unexpceted value", expected, actual);
		}
	}
	
}
