package competitive.leetcode.hard.misc;

public class TrappingRainWater {
	
	 public int trap(int[] height) {
        int[] maxToLeft = new int[height.length];
        int[] maxToRight = new int[height.length];
        int max = -1;
        for (int i=0; i<height.length; i++) {
        	maxToLeft[i] = max;
        	if (height[i] > max) 
        		max = height[i]; 
        }
        max = -1;
        for (int i=height.length-1; i>=0; i--) {
        	maxToRight[i] = max;
        	if (height[i] > max) 
        		max = height[i]; 
        }
        
        int water = 0;
        for (int i=0; i<height.length; i++) {
        	if (maxToLeft[i] == -1 || maxToRight[i] == -1) continue;
        	int myWater = Math.max(0, Math.min(maxToLeft[i],  maxToRight[i]) - height[i]);
        	water += myWater;
        }
        return water;
    }
    
    public static void main(String[] args) {
    	System.out.println(new TrappingRainWater().trap(new int[] {4}));
	}
}
