package competitive.leetcode.hard.design;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {

	Integer i;
	List<NestedInteger> list;
	
	NestedIntegerImpl(Integer i) {
		this.i = i;
	}
	
	NestedIntegerImpl(List<NestedInteger> list) {
		this.list = list;
	}
	
	@Override
	public boolean isInteger() {
		return i != null;
	}

	@Override
	public Integer getInteger() {
		return i;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}
	
}


public class NestedIterator implements Iterator<Integer> {

	private class LookaheadIterator implements Iterator<NestedInteger> {

		private Iterator<NestedInteger> itr;
		private NestedInteger element;
		LookaheadIterator(Iterator<NestedInteger> itr) {
			this.itr = itr;
		}
		
		private boolean notEmpty(NestedInteger node) {
			if (node.isInteger()) return true;
			for (NestedInteger e: node.getList()) {
				if (notEmpty(e)) return true;
			}
			return false;
		}
		
		@Override
		public boolean hasNext() {
			if (element != null) return true;
			while(itr.hasNext()) {
				element = itr.next();
				if (notEmpty(element))
					return true;
			}
			return false;
		}

		@Override
		public NestedInteger next() {
			NestedInteger result = element;
			element = null;
			return result;
		}
	}
	
	private Deque<LookaheadIterator> itrStack = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
    	Iterator<NestedInteger> itr = nestedList.iterator(); 
   		itrStack.push(new LookaheadIterator(itr));
    }

    @Override
    public Integer next() {
    	if (itrStack.isEmpty()) return null;
    	LookaheadIterator itr = itrStack.peekFirst();
    	if (itr.hasNext()) {
    		NestedInteger e = itr.next();
    		if (e.isInteger()) return e.getInteger();
    		LookaheadIterator subItr = new LookaheadIterator(e.getList().iterator());
   			itrStack.push(subItr);
    		return next();
    	} else {
    		itrStack.pop();
    		return next();
    	}
    }

    @Override
    public boolean hasNext() {
    	if (itrStack.isEmpty()) return false;
    	LookaheadIterator itr = itrStack.peekFirst();
    	if (!itr.hasNext()) {
    		itrStack.pop();
    		return hasNext();
    	} else {
    		return true;
    	}
    }
    
    public static void main(String[] args) {
    	List<NestedInteger> subsubsublist = new LinkedList<>();
    	List<NestedInteger> subsublist = Arrays.asList(new NestedIntegerImpl(100), new NestedIntegerImpl(subsubsublist), new NestedIntegerImpl(200), new NestedIntegerImpl(300));
    	List<NestedInteger> sublist = Arrays.asList(new NestedIntegerImpl(10), new NestedIntegerImpl(20), new NestedIntegerImpl(subsublist), new NestedIntegerImpl(30));
    	List<NestedInteger> list = Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(2), new NestedIntegerImpl(sublist), new NestedIntegerImpl(3));
//    	List<NestedInteger> list = Arrays.asList(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(new LinkedList<>()))), new NestedIntegerImpl(new LinkedList<>()));
    	Iterator<Integer> itr = new NestedIterator(list);
    	while (itr.hasNext()) {
    		System.out.println(itr.next());
    	}
    	
	}
}