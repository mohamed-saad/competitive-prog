package competitive.mit.scc;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.scc.Kosaraju;
import competitive.mit.scc.StrongleConnectedComponents;

@RunWith(Parameterized.class)
public class StrongleConnectedComponentsTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
				new Object[] {
						new String[] { "1-0", "0-2", "2-1", "0-3", "3-4" } ,
						5,
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
	
	private StrongleConnectedComponents implementation;
	
	@Before
	public void setup() {
		implementation = new Kosaraju();
	}
	
	@Test
	public void test() {
		List<List<Integer>> scc = implementation.find(nodesCount, graph);
		System.out.println(scc);
		Assert.assertEquals(expected, scc.size());
	}
}
