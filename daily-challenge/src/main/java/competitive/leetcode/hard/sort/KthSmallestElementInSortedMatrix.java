package competitive.leetcode.hard.sort;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
	
    public int kthSmallest(int[][] matrix, int k) {
    	PriorityQueue<int[]> queue = new PriorityQueue<>((a1,a2) -> a1[0] - a2[0]);
    	int rows = matrix.length;
    	int cols = matrix[0].length;

    	for (int r=0; r<rows; r++) {
    		queue.add(new int[] { matrix[r][0], r});	// init the queue
    	}
    	
    	int counter = 0;
    	int lastPoped = 0;
    	int[] rowIndex  = new int[rows];
    	while(counter != k) {
    		int[] smallest = queue.remove();
    		lastPoped = smallest[0];
    		int popedRow = smallest[1];
    		rowIndex[popedRow]++;
    		if (rowIndex[popedRow] < cols)
    			queue.add(new int[] { matrix[popedRow][rowIndex[popedRow]], popedRow });
    		
    		counter++;
    	}
    	
    	return lastPoped;
    }
    
    public static void main(String[] args) {
//		int[][] matrix = {{1,5,19}, {10,11,23}, {12,13,25}};
//		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int[][] matrix = {{-1}};
		System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(matrix, 1));
	}
    
}
