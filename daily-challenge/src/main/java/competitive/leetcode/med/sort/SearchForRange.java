package competitive.leetcode.med.sort;

import java.util.Arrays;

public class SearchForRange {
	
	public int searchRange(int[] nums, int target, int from, int to) {
		if (from > to) return -1;
		int mid = (from + to)/2;
		if (target > nums[mid]) 
			return searchRange(nums, target, mid+1, to);
		if (target < nums[mid])
			return searchRange(nums, target, from, mid-1);
		return mid;
	}
	
    public int[] searchRange(int[] nums, int target) {
    	int pivot = searchRange(nums, target, 0, nums.length-1);
    	if (pivot == -1) return new int[]  {-1,-1};
    	
		int highPivot = pivot;
		int high = highPivot;
		while (highPivot != -1) {
			high = highPivot;
			highPivot = searchRange(nums, target, highPivot+1, nums.length-1);
		}

		int lowPivot = pivot;
		int low = lowPivot;
		while (lowPivot != -1) {
			low = lowPivot;
			lowPivot = searchRange(nums, target, 0, lowPivot-1);
		}
    	
		return new int[] {low, high};
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[] {5,7,7,8,8,8,8,8,8,10};
		System.out.println(Arrays.toString(new SearchForRange().searchRange(nums, 8)));
	}
}
