package competitive.leetcode.med.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public List<List<Integer>> findSum(int[] nums, int from, int sum, int count) {
		if (count == 1) {
			List<List<Integer>> results = new LinkedList<>();
			List<Integer> result = new LinkedList<>();
			for (int i=from; i<nums.length; i++) {
				if (sum == nums[i]) {
					result.add(nums[i]);
					results.add(result);
					break;
				}
			}
			return results;
		}
		
		List<List<Integer>> results = new LinkedList<>();
		for (int i=from; i<nums.length; i++) {
			for (List<Integer> list: findSum(nums, i+1, sum-nums[i], count-1)) {
				list.add(nums[i]);
				results.add(list);
			}
		}
		return results;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> all = findSum(nums, 0, 0, 3);
		Set<List<Integer>> unique = new HashSet<>();
		for (List<Integer> l: all) {
			l.sort((x,y) -> (x>y ? 1 : -1));
			unique.add(l);
		}
		List<List<Integer>> results = new LinkedList<>();
		results.addAll(unique);
		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(new ThreeSum().threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
}
