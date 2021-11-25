package competitive.leetcode.med.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	
	private List<List<Integer>> result;
	private int[] buffer;
	private int[] nums;
	
	private void permute(int i) {
		if (i == buffer.length) {
			List<Integer> r = new LinkedList<>();
			for (int b: buffer) r.add(b);
			result.add(r);
			return;
		}
		for (int j=0; j<nums.length; j++) {
			boolean skip = false;
			for (int k=0; k<i; k++) {
				if (buffer[k] == nums[j]) {
					skip = true;
					break;
				}
			}
			if (skip) continue;
			buffer[i] = nums[j];
			permute(i+1);
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	this.result = new LinkedList<>();
    	this.nums = nums;
    	this.buffer = new int[nums.length];
    	permute(0);
        return this.result;
    }
    
    public static void main(String[] args) {
		System.out.println(new Permutations().permute(new int[] {1}));
	}

}
