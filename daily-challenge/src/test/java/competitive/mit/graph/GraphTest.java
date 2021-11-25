package competitive.mit.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.graph.Graph;
import competitive.mit.graph.IGraph;


@RunWith(Parameterized.class)
public class GraphTest {

	@Parameters
	public static Object[] testCases() {
		return new Object[] {
				new Object[] { new String[] { "a,5,b", "b,1,c", "c,2,a", "a,3,d", "d,1,e", "e,1,b", "c,1,e" }, 5 },
		};
	}
	
	@Parameter(0)
	public String[] edges;
	
	@Parameter(1)
	public int expectedNodes;
	
	private IGraph<Character, Boolean, Integer> implementation;
	
	@Before
	public void setup() {
		implementation = new Graph<Character, Boolean, Integer>();
	}
	
	@Test
	public void test() {
		for (String edge: edges) {
			String[] parts = edge.split(",");
			implementation.addEdge(
					implementation.addOrGetNode(parts[0].charAt(0)), 
					implementation.addOrGetNode(parts[2].charAt(0)), 
					Integer.parseInt(parts[1]));
		}
		Assert.assertEquals(expectedNodes, implementation.getNodes().size());
	}
	
	
}
