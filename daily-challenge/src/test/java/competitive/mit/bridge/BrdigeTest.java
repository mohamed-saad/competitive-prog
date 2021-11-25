package competitive.mit.bridge;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.bridge.Bridge;
import competitive.mit.bridge.Tarjan;

@RunWith(Parameterized.class)
public class BrdigeTest {
	
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
	
	private Bridge implementation;
	
	@Before
	public void setup() {
		implementation = new Tarjan();
	}
	
	@Test
	public void test() {
		List<String> bridges = implementation.find(nodesCount, Arrays.asList(graph));
		System.out.println(bridges);
//		System.out.println(scc);
//		Assert.assertEquals(expected, scc.size());
	}
}
