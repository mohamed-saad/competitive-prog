package competitive.leetcode.med.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

	private List<List<Integer>> result;
	private int[] nums;
	private int[] buff;
	
	private void subsetWithLength(int first, int index, int maxLength) {
		if (index == maxLength) {
			List<Integer> list = new ArrayList<>(maxLength);
			for (int i=0; i<maxLength; i++)
				list.add(buff[i]);
			result.add(list);
			return;
		}
		
		for (int i=first; i<nums.length; i++) {
			buff[index] = nums[i];
			subsetWithLength(i+1, index+1, maxLength);
		}
	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	this.result = new LinkedList<>();
    	this.nums = nums;
    	this.buff = new int[nums.length];
    	for (int elements=0; elements<=nums.length; elements++)
    		subsetWithLength(0, 0, elements);
    	return result;
    }
    
    public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[] {1,2,3,4}));
	}
}
