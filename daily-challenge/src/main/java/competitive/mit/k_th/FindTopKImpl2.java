package competitive.mit.k_th;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindTopKImpl2 implements FindTopK {

	@Override
	public Integer[] topK(List<Integer> elements, int k, boolean top) {
		
		if (top) {
			elements = elements.stream().map(i -> i * -1).collect(Collectors.toList());
		}
		
		PriorityQueue<Integer> minMaxHeap = new PriorityQueue<>(elements);
		Integer[] topElements = new Integer[k];
		int counter = 0;
		while (counter++ < k) {
			topElements[k-counter] = minMaxHeap.remove();
			if (top) topElements[k-counter] *= -1;
		} 

		return topElements;
	}

}
