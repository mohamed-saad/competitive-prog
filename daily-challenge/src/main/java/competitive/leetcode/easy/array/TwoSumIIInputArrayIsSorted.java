package competitive.leetcode.easy.array;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
    	int right = numbers.length-1;
    	int left = 0;
    	
    	while(left < right) {
    		int rightTarget = target - numbers[right];
    		if (rightTarget < numbers[left]) right--;
    		else if (rightTarget == numbers[left]) 
    			return new int[] {left + 1, right + 1};
    		else left++;
    	}
    	
    	return new int[] {-1, -1};	// can't happen
    }
    
}
