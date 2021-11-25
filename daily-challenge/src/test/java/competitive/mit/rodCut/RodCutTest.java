package competitive.mit.rodCut;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.rodCut.RodCut;
import competitive.mit.rodCut.RodCutImpl;

@RunWith(Parameterized.class)
public class RodCutTest {

	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] {
				(Function<Integer, Integer>)((i) -> { return (i+1)*2; }),
				10,
				40
			}
		};
	}
	
	@Parameter(0)
	public Function<Integer, Integer> cost;
	
	@Parameter(1)
	public Integer rodLength;

	@Parameter(2)
	public Integer expected;
	
	private RodCut implementation;
	
	@Before
	public void setup() {
		implementation = new RodCutImpl();
	}
	
	@Test
	public void test() {
		Integer actual = implementation.getMaxRevenue(cost, rodLength);
		Assert.assertEquals(expected, actual);
	}
}
