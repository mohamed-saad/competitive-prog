package competitive.leetcode.med.sort;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] colorsCount = new int[3];
        for (int n: nums)
        	colorsCount[n]++;
        int e = 0;
        for (int c=0; c<colorsCount.length; c++)
        	for (int i=0; i<colorsCount[c]; i++)
        		nums[e++] = c;
    }
}
