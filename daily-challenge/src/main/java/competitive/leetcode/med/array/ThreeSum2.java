package competitive.leetcode.med.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum2 {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new LinkedList<>();
		Arrays.sort(nums);
		int target = 0;
		int prev = Integer.MIN_VALUE;
		for (int i=0; i<nums.length - 2; i++) {
			
			if (nums[i] == prev) continue;
			prev = nums[i];
			
			int l = i+1;
			int r = nums.length-1;
			while (l<r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == target) {
					results.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					while(l<r && nums[l]==nums[l-1]) {
						l++;
					}
				} else if (sum > target) {
					r--;
				} else {
					l++;
				}
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(new ThreeSum2().threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
}
