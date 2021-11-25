package competitive.mit.bst;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import competitive.mit.bst.BST;
import competitive.mit.bst.BSTImpl;

@RunWith(Parameterized.class)
public class BSTTest {
	
	@Parameters
	public static Object[] testCases() {
		return new Object[] {
			new Object[] {
				new Integer[] {100, 200, 50, 300, 250, 280, 240, 40, 10, 20, 120, 245},
				new Integer[] {10, 20, 40, 50, 100, 120, 200, 240, 245, 250, 280, 300},
			}
		};
	}
	
	@Parameter(0)
	public Integer[] elements;
	
	@Parameter(1)
	public Integer[] expected;
	
	private BST<Integer> implementation;
	
	@Before
	public void setup() {
		implementation = new BSTImpl<Integer>();
	}
	
	@Test
	public void testAdd() {
		for (Integer i: elements)
			implementation.add(i);
		
		Iterator<Integer> itr = implementation.inOrder().iterator();
		for (Integer e: expected) {
			Assert.assertEquals(e, itr.next());
		}
		Assert.assertFalse(itr.hasNext());
	}

	@Test
	public void testRemove() {
		for (Integer i: elements)
			implementation.add(i);
		
		implementation.remove(200);
		Assert.assertFalse(implementation.inOrder().contains(200));
		
		implementation.remove(100);
		Assert.assertFalse(implementation.inOrder().contains(100));
		
		implementation.remove(280);
		Assert.assertFalse(implementation.inOrder().contains(280));
		
		Assert.assertEquals(implementation.inOrder().size(), elements.length - 3);
	}
}
