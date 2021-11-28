package competitive.leetcode.easy.array;

import java.util.Arrays;

public class RemoveElement {
    
	public int removeElement(int[] nums, int val) {
		int size = nums.length;
		int index = 0;
		while (index < size) {
			if (nums[index] == val) {
				nums[index] = nums[size-1];
				nums[size-1] = 0;
				size--;
			} else {
				index++;
			}
		}
		return size;
    }
	
	private static void test(int[] nums, int val) {
		System.out.print(Arrays.toString(nums));
		new RemoveElement().removeElement(nums, val);
		System.out.println("==>" + Arrays.toString(nums));
	}
	
	public static void main(String[] args) {
		test(new int[] {0,1,2,2,3,0,4,2}, 2);
		test(new int[] {0,1,2,2,3,0,4,2}, 12);
		test(new int[] {}, 2);
	}
}
