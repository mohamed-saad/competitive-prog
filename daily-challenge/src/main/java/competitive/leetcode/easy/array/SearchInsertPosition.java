package competitive.leetcode.easy.array;

public class SearchInsertPosition {
	
	private int searchInsert(int[] nums, int target, int from, int to) {
        if (from > to) return from;
        int mid = from + (to - from)/2;	// avoid overflow
        if (target == nums[mid]) return mid;
        if (target < nums[mid]) return searchInsert(nums, target, from, mid-1);
        return searchInsert(nums, target, mid+1, to);
    }
	
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }
    
    public static void main(String[] args) {
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 0));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 1));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 2));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 4));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 5));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 7));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,4,6,9}, 10));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 0));
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1}, 0));
	}
    
    
}
