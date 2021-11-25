package competitive.leetcode.easy.misc;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int mask = 0;
        // build the mask
        for (int i=1; i<=nums.length; i++)
        	mask ^= i;
        // apply the mask
        for (int i=0; i<nums.length; i++)
        	mask ^= nums[i];
        return mask;
    }
    
    public static void main(String[] args) {
		System.out.println(new MissingNumber().missingNumber(new int[] {1,2,0,4}));
	}
}
