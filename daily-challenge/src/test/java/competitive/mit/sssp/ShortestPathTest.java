package competitive.mit.sssp;

import java.util.Arrays;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.sssp.BallmanFordDP;
import competitive.mit.sssp.ShortestPath;

@RunWith(Parameterized.class)
public class ShortestPathTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] {
				'a',
				new String[] { "a,10,b", "b,1,c", "c,2,d", "a,3,d", "d,1,e", "e,1,f", "c,1,f" },
				new String[] { "a=0", "b=10", "c=11", "d=3", "e=4", "f=5" }
			},
			
			new Object[] {
				'b',
				new String[] { "a,10,b", "b,-1,c", "c,-2,d", "d,3,a", "c,-1,e", "e,1,a", "c,1,a" },
				new String[] { "a=-1", "b=0", "c=-1", "d=-3", "e=-2" }
			},
				
			new Object[] {
					'a',
					new String[] { "a,10,b", "b,-1,c", "c,-2,b" },
					new String[] { "a=0", "b=10" }
				}	
		};
	}
	
	@Parameter(0)
	public Character from;
	
	@Parameter(1)
	public String[] edges;
	
	@Parameter(2)
	public String[] expected;
	
	private ShortestPath implementation;
	
	@Before
	public void setup() {
//		implementation = new DAGRelaxation();
//		implementation = new Dijkstra();
//		implementation = new DAGRelaxationDP();
		implementation = new BallmanFordDP();
	}
	
	@Test
	public void test() {
		Map<Character, Integer> actual = implementation.shortestPath(from, Arrays.asList(edges));
//		System.out.println(actual);
		for (String p: expected) {
			String[] parts = p.split("=");
			Assert.assertEquals((Integer)Integer.parseInt(parts[1]), actual.get(parts[0].charAt(0)));
		}
	}

}
