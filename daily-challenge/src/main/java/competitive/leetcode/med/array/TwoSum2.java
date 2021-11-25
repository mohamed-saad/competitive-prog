package competitive.leetcode.med.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoSum2 {
	
	public List<List<Integer>> twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> results = new LinkedList<>();
		int l=0;
		int r=nums.length-1;
		while (l<r) {
			int sum = nums[l] + nums[r];
			if (sum == target) {
				results.add(Arrays.asList(nums[l], nums[r]));
				l++;
				while(l<r && nums[l] == nums[l-1]) {
					l++;
				}
			} else if (sum > target) {
				r--;
			} else {
				l++;
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(new TwoSum2().twoSum(new int[] {-1,0,1,2,-1,-4}, 0));
	}
}
