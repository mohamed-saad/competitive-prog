package competitive.mit.disconnected;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.diconnected.Disconnected;
import competitive.mit.diconnected.DisconnectedDFS;

@RunWith(Parameterized.class)
public class DisconnectedTest {
	
	@Parameters
	public static Object[] testcases() {
		return new Object[] {
				new Object[] {
						new String[] { "a-b", "b-c", "d-e", "e-f", "g-h" },
						3
				},
		};
	}
	
	@Parameter(0)
	public String[] edges;
	
	@Parameter(1)
	public int expected;
	
	private Disconnected implementation;
	
	@Before
	public void setup() {
		implementation = new DisconnectedDFS();
	}
	
	@Test
	public void test() {
		Map<Character, Integer> actual = implementation.islands(edges);
		System.out.println(actual);
		Set<Integer> groups = new HashSet<>();
		groups.addAll(actual.values());
		Assert.assertEquals(expected, groups.size());
	}

}
