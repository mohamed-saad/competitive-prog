package competitive.mit.dfs;

import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.dfs.DFS;
import competitive.mit.dfs.DFSImpl;

@RunWith(Parameterized.class)
public class DFSTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] { 
				'a',
				new String[] { "a,10,b", "b,1,c", "c,2,a", "a,3,d", "d,1,e", "e,1,b", "c,1,e" },
				"a,d,e,b,c",
			}
		};
	}
	
	@Parameter(0)
	public Character from;
	
	@Parameter(1)
	public String[] edges;
	
	@Parameter(2)
	public String expected;
	
	private DFS implementation; 
	
	@Before
	public void setup() {
		implementation = new DFSImpl();
	}
	
	@Test
	public void test() {
		String actual = implementation.dfs(from, edges).stream().map(c -> c.toString()).collect(Collectors.joining(","));
		Assert.assertEquals(expected, actual);
	}
	
	

}
