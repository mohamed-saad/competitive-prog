package competitive.leetcode.med.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> freq = new HashMap<>();
    	for (int n: nums)
    		freq.compute(n, (key,v) -> v == null ? 1 : v+1);
    	PriorityQueue<Map.Entry<Integer, Integer>> top = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
    	for (Entry<Integer, Integer> e: freq.entrySet()) {
    		if (top.size() < k)
    			top.add(e);
    		else {
    			if (top.peek().getValue() < e.getValue()) {
    				top.remove();
    				top.add(e);
    			}
    		}
    	}
    	int[] topK = new int[k];
    	int i = 0;
    	for (Entry<Integer, Integer> e: top) {
    		topK[i++] = e.getKey();
    	}
    	return topK;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[] {1}, 1)));
	}
    
}
