package competitive.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
        	set.add(nums[i]);
        	if (set.size() < i-1) return true;
        }
        return set.size() < nums.length;
    }
    
    public static void main(String[] args) {
    	System.out.println(new ContainsDuplicate().containsDuplicate(new int[] {1,2,3,1,4}));
	}
}
