package competitive.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
    	for (int i=0; i<nums.length; i++) {
    		Integer index = numbers.get(target - nums[i]);
    		if (index != null) {
    			return new int[] {index, i};
    		}
    		numbers.put(nums[i], i);
    	}
    	return null;
    } 
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new TwoSum().twoSum(new int[] {3,2,4}, 6)));
	}
}
