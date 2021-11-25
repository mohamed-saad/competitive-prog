package competitive.mit.subsetSum;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class SubsetSumImpl2 implements SubsetSum{

	private Map<String, Boolean> memo = new HashMap<>();
	
	private int calls = 0;
	public boolean subsetSum(Integer[] set, int targetSum, int from) {
		String key = targetSum + "-" + from;
		Boolean m = memo.get(key);
		if (m != null) return m;
		calls++;
		if (targetSum == 0 && set.length == from) return true;
		
		for (int i=from; i<set.length; i++) {
			boolean without = subsetSum(set, targetSum, from+1);
			boolean with = subsetSum(set, targetSum - set[from], from+1);
			if (with || without) {
				memo.put(key, true);
				return true;
			}
		}
		
		memo.put(key, false);
		return false;
	}
	
	@Override
	public boolean subsetSum(Set<Integer> set, int targetSum) {
		Integer[] input = set.toArray(new Integer[set.size()]);
		boolean exist = subsetSum(input, targetSum, 0);
		System.out.println("Calls " + calls);
		return exist;
	}

}
