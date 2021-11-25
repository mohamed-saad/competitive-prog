package competitive.mit.bfs;

import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.bfs.BFS;
import competitive.mit.bfs.BFSImpl;


@RunWith(Parameterized.class)
public class BFSTest {

	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] { 
				'a',
				new String[] { "a,10,b", "b,1,c", "c,2,a", "a,3,d", "d,1,e", "e,1,b", "c,1,e" },
				"a,b,d,c,e",
			}
		};
	}
	
	@Parameter(0)
	public Character from;
	
	@Parameter(1)
	public String[] edges;
	
	@Parameter(2)
	public String expected;
	
	private BFS algorithm;
	
	@Before
	public void setup() {
		algorithm = new BFSImpl();
	}
	
	@Test
	public void test() {
		String actual = algorithm.bfs(from, edges).stream().map(c -> c.toString()).collect(Collectors.joining(","));
		Assert.assertEquals(expected, actual);
	}

}
