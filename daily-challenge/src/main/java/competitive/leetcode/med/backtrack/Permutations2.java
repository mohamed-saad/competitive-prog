package competitive.leetcode.med.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutations2 {
	
	private List<List<Integer>> result;
	private int[] nums;
	
	private void swap(int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	private void permute(int i) {
		if (i == nums.length) {
			List<Integer> r = new LinkedList<>();
			for (int b: nums) r.add(b);
			result.add(r);
			return;
		}
		for (int j=i; j<nums.length; j++) {
			swap(i, j);
			permute(i+1);
			swap(j, i);
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	this.result = new LinkedList<>();
    	this.nums = nums;
    	permute(0);
        return this.result;
    }
    
    public static void main(String[] args) {
		System.out.println(new Permutations2().permute(new int[] {1,2,3}));
	}

}
