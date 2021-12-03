package competitive.leetcode.easy.array;

public class MajorityElement {

    public int majorityElement(int[] nums) {
    	int element = nums[0];
    	int votes = 1;
    	for (int i=1; i<nums.length; i++) {
    		if (nums[i] == element) votes++;
    		else votes--;
    		if (votes == 0) {
    			element = nums[i];
    			votes = 1;
    		}
    	}
    	return element;
    }
    
    public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(new int[] {2,2,1,1,1,2,2}));
		System.out.println(new MajorityElement().majorityElement(new int[] {2,2,2,2,1,1,1}));
		System.out.println(new MajorityElement().majorityElement(new int[] {1,1,1,2,2,2,2}));
		System.out.println(new MajorityElement().majorityElement(new int[] {2,1,2,1,2,1,2}));
	}
    
}
