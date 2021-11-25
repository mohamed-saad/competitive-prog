package competitive.mit.k_th;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class FindTopKImpl implements FindTopK {

	@Override
	public Integer[] topK(List<Integer> elements, int k, boolean top) {
		
		PriorityQueue<Integer> minMaxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (top) {
					return o1 > o2 ? 1 : -1;
				} else {
					return o1 > o2 ? -1 : 1;
				}
			}
		});
		
		int counter = 0;
		Iterator<Integer> itr = elements.iterator();
		while (itr.hasNext() && counter++ < k) {
			minMaxHeap.add(itr.next());
		}
		while(itr.hasNext()) {
			int i = itr.next();
			int minTop = minMaxHeap.peek();
			if (top && i > minTop || !top && i < minTop) {
				minMaxHeap.remove();
				minMaxHeap.add(i);
			}
		}
		
		return minMaxHeap.toArray(new Integer[k]);
	}

}
