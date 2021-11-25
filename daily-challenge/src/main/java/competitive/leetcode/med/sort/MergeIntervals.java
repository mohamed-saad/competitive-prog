package competitive.leetcode.med.sort;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1,a2) -> a1[0] - a2[0]);
        Deque<int[]> stack = new LinkedList<>();
        stack.push(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
        	int intervalStart = intervals[i][0];
        	int intervalEnd = intervals[i][1];
        	if (stack.peekFirst()[1] >= intervalStart) {	// intersection
        		int[] old = stack.pop();
        		int[] merged = new int[] { old[0], Math.max(old[1], intervalEnd) };
        		stack.push(merged);
        	} else {
        		stack.push(intervals[i]);
        	}
        }
        int[][] result = new int[stack.size()][2];
        for (int i=result.length-1; i>=0; i--)
        	result[i] = stack.pop();
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][] {{3,11},{2,6},{6,7},{8,10},{15,18}})));
	}
}
