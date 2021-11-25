package competitive.mit.histogram;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangle {

	public int find(int[] histogram) {
		int[] left = new int[histogram.length];
		int[] right = new int[histogram.length];
		Deque<Integer> stack = new LinkedList<>();
		for (int i=0; i<histogram.length; i++) {
			while (!stack.isEmpty()) {
				int top = stack.peek();
				if (histogram[top] < histogram[i]) {
					left[i] = top+1;
					break;
				} else {
					stack.pop();
				}
			}
			stack.push(i);
		}
		
		stack.clear();
		for (int i=histogram.length-1; i>=0; i--) {
			right[i] = histogram.length-1;
			while (!stack.isEmpty()) {
				int top = stack.peek();
				if (histogram[top] < histogram[i]) {
					right[i] = top-1;
					break;
				} else {
					stack.pop();
				}
			}
			stack.push(i);
		}
		
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<histogram.length; i++) {
			max = Math.max(max, (right[i]-left[i]+1)*histogram[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new LargestRectangle().find(new int[] { 2, 1, 5, 6, 2, 3 }));
//		System.out.println(new LargestRectangle().find(new int[] { 2, 1, 5, 0, 2, 3 }));
//		System.out.println(new LargestRectangle().find(new int[] { 2, 1, 0, 0, 0, 0 }));

	}
	
}
