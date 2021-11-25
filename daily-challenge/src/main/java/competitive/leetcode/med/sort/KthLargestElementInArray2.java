package competitive.leetcode.med.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInArray2 {

    public int findKthLargest(int[] nums, int k) {
    	List<Integer> l = new LinkedList<>();
    	for (int n: nums) l.add(n * -1);
        PriorityQueue<Integer> queue = new PriorityQueue<>(l);	// max heap
        for (int i=0; i<k-1; i++)
        	queue.remove();
        return queue.remove() * -1;
    }
    
    public static void main(String[] args) {
		System.out.println(new KthLargestElementInArray2().findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}
}
