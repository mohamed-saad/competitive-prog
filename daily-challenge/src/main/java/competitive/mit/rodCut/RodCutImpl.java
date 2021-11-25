package competitive.mit.rodCut;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class RodCutImpl implements RodCut {
	
	private Map<Integer, Integer> memo = new HashMap<>();

	@Override
	public int getMaxRevenue(Function<Integer, Integer> cost, int rodLength) {
		if (rodLength == 0) return 0;
		Integer m = memo.get(rodLength);
		if (m != null) return m;
		int max = Integer.MIN_VALUE;
		for (int i=1; i<=rodLength; i++) {
			int value = cost.apply(i) + getMaxRevenue(cost, rodLength-i);
			if (value > max) max = value;
		}
		memo.put(rodLength, max);
		return max;
	}

}
