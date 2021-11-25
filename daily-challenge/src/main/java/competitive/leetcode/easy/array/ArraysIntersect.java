package competitive.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArraysIntersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] smallest;
        int[] longest;
        if (nums1.length < nums2.length) {
        	smallest = nums1; 
        	longest = nums2;
        } else {
        	smallest = nums2; 
        	longest = nums1;
        }
        Map<Integer, Integer> histo1 = new HashMap<>();
        for (int i=0; i<smallest.length; i++) {
        	histo1.compute(smallest[i], (k,v) ->  v == null ? 1 : v+1);
        }
        List<Integer> intersection = new LinkedList<>();
        for (int i=0; i<longest.length; i++) {
        	histo1.computeIfPresent(longest[i], (k,v) -> { intersection.add(k); return v == 1 ? null : v-1; } );
        }
        int[] result = new int[intersection.size()];
        int c = 0;
        for(Integer i: intersection)
        	result[c++] = i;
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new ArraysIntersect().intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
	}
    
}
