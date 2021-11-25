package competitive.mit.subsetSum;

import java.util.Set;

public class SubsetSumImpl implements SubsetSum {

	@Override
	public boolean subsetSum(Set<Integer> set, int targetSum) {
		if (targetSum < 0 ) return false;
		if (set.size() == 0 && targetSum == 0) return true;

		Integer[] elements = set.toArray(new Integer[set.size()]);
		for (int i=0; i<set.size(); i++) {
			set.remove(elements[i]);
			if (targetSum == elements[i]) return true;
			boolean e = subsetSum(set, targetSum - elements[i]);
			set.add(elements[i]);
			if (e) return true;
		}
		
		return false;
	}

}
