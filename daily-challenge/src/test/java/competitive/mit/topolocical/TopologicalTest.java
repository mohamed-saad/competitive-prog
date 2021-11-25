package competitive.mit.topolocical;

import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.topolocical.Topological;
import competitive.mit.topolocical.TopologicalImplRecursive;

@RunWith(Parameterized.class)
public class TopologicalTest {

	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] { 
				new String[] { "a,10,b", "b,1,c", "c,2,e", "a,3,d", "d,1,e", "e,1,f", "c,1,f" },
				"f,e,d,c,b,a",
			}
		};
	}
	
	@Parameter(0)
	public String[] edges;
	
	@Parameter(1)
	public String expected;
	
	private Topological implementation;
	
	@Before
	public void setup() {
//		implementation = new TopologicalImpl();
		implementation = new TopologicalImplRecursive();
	}
	
	@Test
	public void test() {
		String actual = implementation.sort(edges).stream().map(c -> c.toString()).collect(Collectors.joining(","));
		Assert.assertEquals(expected, actual);
	}
	
}
