package competitive.leetcode.easy.array;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i=0; i<nums.length; i++) {
        	x = x ^ nums[i];
        }
        return x;
    }
    
}
