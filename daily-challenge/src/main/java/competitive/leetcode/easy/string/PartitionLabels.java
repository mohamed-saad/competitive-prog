package competitive.leetcode.easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

	private static final int START = 0;
	private static final int END = 1;
	
    public List<Integer> partitionLabels(String s) {
    	int[][] bounds = new int[26][2];
    	for (int i=0; i<bounds.length; i++) {
    		bounds[i][START] = Integer.MAX_VALUE;
    		bounds[i][END] = Integer.MIN_VALUE;
    	}
    	
    	for (int i=0; i<s.length(); i++) {
    		int index = s.charAt(i)-'a';
    		if (bounds[index][START] > i) bounds[index][START] = i;
    		if (bounds[index][END] < i) bounds[index][END] = i;
    	}
    	
    	Arrays.sort(bounds, (o1,o2) -> o1[0]-o2[0]);
    	
    	int last = 0;
    	for (int i=1; i<bounds.length; i++) {
    		if (bounds[i][START] == Integer.MAX_VALUE) break;
    		if (bounds[i][START] < bounds[last][END]) {	// intersect
    			// merge with previous
    			bounds[last][START] = Math.min(bounds[i][START], bounds[last][START]);
    			bounds[last][END] = Math.max(bounds[i][END], bounds[last][END]);
    		} else {
    			// insert
    			bounds[++last] = bounds[i];
    		}
    	}
    	
    	List<Integer> lengths = new ArrayList<>(last+1);
    	for (int i=0; i<=last; i++){
    		lengths.add(bounds[i][END] - bounds[i][START] + 1);
    	}
        return lengths;
    }
    
    public static void main(String[] args) {
		System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(new PartitionLabels().partitionLabels("eccbbbbdec"));
	}
}
