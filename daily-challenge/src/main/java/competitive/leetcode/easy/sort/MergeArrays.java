package competitive.leetcode.easy.sort;

import java.util.Arrays;

public class MergeArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m-1; i>=0; i--) {
        	nums1[i+n] = nums1[i];	// shift elements
        }
        int itr1 = n;
        int itr2 = 0;
        int c = 0;
        while(itr2 < n) {
        	if (itr1 < m+n && nums1[itr1] < nums2[itr2]) {
        		nums1[c] = nums1[itr1];
        		itr1++;
        	} else {
        		nums1[c] = nums2[itr2];
        		itr2++;
        	}
        	c++;
        }
    }
    
    public static void main(String[] args) {
		int[] nums1 = new int[] {0,0,0,0};
		int[] nums2 = new int[] {2,5,6,7};
		new MergeArrays().merge(nums1, 0, nums2, 4);
		System.out.println(Arrays.toString(nums1));
	}
    
}
