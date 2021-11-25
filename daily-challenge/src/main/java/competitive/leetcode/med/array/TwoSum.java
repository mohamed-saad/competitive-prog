package competitive.leetcode.med.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TwoSum {
	
	public List<List<Integer>> twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> results = new LinkedList<>();
		Set<Integer> diff = new HashSet<>();
		for (int i: nums) {
			if (diff.contains(i)) {
				results.add(Arrays.asList(i, target-i));
			}
			diff.add(target - i);
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(new TwoSum().twoSum(new int[] {-1,0,1,2,-1,-4}, 0));
	}
}
