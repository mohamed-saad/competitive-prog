package competitive.mit.articulation;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.articulation.ArticulationPoint;
import competitive.mit.articulation.Tarjan;

@RunWith(Parameterized.class)
public class ArticulationPointTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
				new Object[] {
						new String[] { "1-0", "0-2", "2-1", "0-3", "3-4", "4-5" } ,
						6,
						3
				},
		};
	}
	
	@Parameter(0)
	public String[] graph;

	@Parameter(1)
	public int nodesCount;
	
	@Parameter(2)
	public int expected;
	
	private ArticulationPoint implementation;
	
	@Before
	public void setup() {
		implementation = new Tarjan();
	}
	
	@Test
	public void test() {
		List<Integer> ap = implementation.find(nodesCount, Arrays.asList(graph));
		System.out.println(ap);
//		System.out.println(scc);
		Assert.assertEquals(expected, ap.size());
	}
}
