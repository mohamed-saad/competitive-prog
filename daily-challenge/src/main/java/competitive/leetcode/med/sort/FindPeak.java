package competitive.leetcode.med.sort;

public class FindPeak {

	private int findPeakElement(int[] nums, int from, int to) {
		int mid = (from + to) / 2;
		if (mid > 0 && nums[mid] < nums[mid-1]) // go left
			return findPeakElement(nums, from, mid-1);
		else if (mid < nums.length-1 && nums[mid] < nums[mid+1])
			return findPeakElement(nums, mid+1, to);
		return mid;	// found a peak
    }

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }
    
    public static void main(String[] args) {
    	int[] l0 = new int[] {1,2,3,1};
    	int[] l1 = new int[] {1,2,3,4,5,6,7,8};
    	int[] l2 = new int[] {8,7,6,5,4,3,2,1};
    	int[] l3 = new int[] {1,2,3,4,8,7,6,5,4,3,2,1};
		System.out.println(new FindPeak().findPeakElement(l0));
	}
    
}
