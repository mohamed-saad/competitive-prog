package competitive.mit.rodCut;

import java.util.function.Function;

public interface RodCut {

	int getMaxRevenue(Function<Integer, Integer> cost, int rodLength);
	
}
