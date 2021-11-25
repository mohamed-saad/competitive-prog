package competitive.leetcode.med.sort;

public class SearchRotatedSortedArray {
	
	private int findRotationPoint(int[] nums, int from, int to) {
		if (from >= to) return from;
		int mid = (from + to)/2;
		if (nums[mid] > nums[to]) {
			return findRotationPoint(nums, mid+1, to);	// something wrong
		} else { 
			return findRotationPoint(nums, from, mid);	// something wrong at the left
		}
	}
	
	private int find(int [] nums, int target, int from, int to) {
		if (from > to) return -1;
		int mid = (from + to)/2;
		if (nums[mid] > target)
			return find(nums, target, from, mid-1);
		else if (nums[mid] < target)
			return find(nums, target, mid+1, to);
		return mid;
	}
	
    public int search(int[] nums, int target) {
    	int start = findRotationPoint(nums, 0, nums.length-1);
    	int i = find(nums, target, start, nums.length-1);
    	if (i == -1)
    		return find(nums, target, 0, start-1);
    	else return i;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {5, 6, 7, 8, 9, 0, 1, 2, 3};
//		int[] nums = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		System.out.println(new SearchRotatedSortedArray().search(nums, 0));
		System.out.println(new SearchRotatedSortedArray().search(nums, 10));
	}
}
