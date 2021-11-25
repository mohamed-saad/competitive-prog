package competitive.leetcode.hard.sort;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] m = nums.clone();
        Arrays.sort(m);
        int j = 0;
        
        int lastLow = nums.length%2 == 0 ? nums.length-2 : nums.length-1;
        int lastHigh = nums.length%2 == 0 ? nums.length-1 : nums.length-2;
        
        for (int i=lastLow; i>=0; i-=2) {
        	nums[i] = m[j++];
        }
        for (int i=lastHigh; i>=1; i-=2) {
        	nums[i] = m[j++];
        }
    }
    
    public static void main(String[] args) {
//    	int[] matrix = new int[] {1,3,2,2,3,1};
    	int[] matrix = new int[] {4,5,5,6};
    	
		new WiggleSortII().wiggleSort(matrix);
		System.out.println(Arrays.toString(matrix));
		
	}
}
