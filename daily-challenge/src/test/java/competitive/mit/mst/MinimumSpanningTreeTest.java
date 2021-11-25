package competitive.mit.mst;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.mst.Kruskal;
import competitive.mit.mst.MinimumSpanningTree;

@RunWith(Parameterized.class)
public class MinimumSpanningTreeTest {

	@Parameters
	public static Object[] testcases() {
		return new Object[] {
			new Object[] {
					new String[] { "0,4,1", "0,8,7", "1,11,7", "1,8,2", "2,2,8", "2,4,5", "2,7,3",
							"3,14,5", "3,9,4", "4,10,5", "5,2,6", "6,6,8", "6,1,7", "7,7,8" },
					9,
					new String[] {}
			}
		};
	}
	
	@Parameter(0)
	public String[] edges;
	
	@Parameter(1)
	public int nodesCount;
	
	@Parameter(2)
	public String[] expected;
	
	private MinimumSpanningTree implementation;
	
	@Before
	public void setup() {
		implementation = new Kruskal();
	}

	@Test
	public void test() {
		List<String> actual =implementation.findMinimumSpanningTree(Arrays.asList(edges), nodesCount);
		System.out.println(actual);
		Set<String> a = new HashSet<>();
		a.addAll(actual);
		for (String e: expected) 
			Assert.assertTrue(a.contains(e));
		Assert.assertEquals(nodesCount - 1, a.size());
	}
	
}
