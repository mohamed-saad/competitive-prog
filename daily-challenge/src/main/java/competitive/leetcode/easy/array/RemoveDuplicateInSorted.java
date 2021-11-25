package competitive.leetcode.easy.array;

import java.util.Arrays;

public class RemoveDuplicateInSorted {

    public int removeDuplicates(int[] nums) {
		int count = nums.length;
		int itr = 1;
		int lastUnique = 1;
		while (itr < count) {
			if (nums[itr] != nums[itr-1]) {
				nums[lastUnique] = nums[itr];
				lastUnique++;
			}
			itr++;
		}
		return lastUnique;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		new RemoveDuplicateInSorted().removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));
	}
	
}
