package competitive.leetcode.hard.array;

public class ContainerWithMostWater2 {
	
    public int maxArea(int[] height) {
    	int maxWater = 0;
    	int from = 0;
    	int to = height.length-1;
    	while (from < to) {
    		maxWater = Math.max(maxWater, (to - from) * Math.min(height[from], height[to]));
    		if (height[from] < height[to])
    			from++;
    		else
    			to--;
    	}
        return maxWater;
    }
    
    public static void main(String[] args) {
    	System.out.println(new ContainerWithMostWater2().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
}
