package competitive.leetcode.med.sort;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();	// min heap
        for (int n: nums) {
        	if (queue.size() < k) 
        		queue.add(n);
        	else {
        		if (queue.peek() < n) {	// check the min of the top K
        			queue.remove();
        			queue.add(n);
        		}
        	}
        }
        return queue.remove();
    }
    
    public static void main(String[] args) {
		System.out.println(new KthLargestElementInArray().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
	}
}
