package competitive.leetcode.hard.array;

public class ContainerWithMostWater {
	
    public int maxArea(int[] height) {
    	int maxWater = 0;
    	int from = 0;
    	int to = 0;
    	for (int i=0; i<height.length; i++)
    		for (int j=i+1; j<height.length; j++) {
    			int myWater = (j-i) * Math.min(height[i], height[j]);
    			if (myWater > maxWater) {
    				maxWater = myWater;
    				from = i;
    				to = j;
    			}
    		}
    	System.out.println(from + ":" + to);
        return maxWater;
    }
    
    public static void main(String[] args) {
    	System.out.println(new ContainerWithMostWater().maxArea(new int[] {1,1}));
	}
}
