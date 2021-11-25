package competitive.leetcode.easy.design;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
	
	private class Node {
		int val;
		int min;
		Node(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
	
	private Deque<Node> stack = new LinkedList<>();
	
	public void push(int val) {
		stack.push(new Node(val, 
				Math.min(val, 
						stack.isEmpty() ? val : getMin())));
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().val;
	}

	public int getMin() {
		return stack.peek().min;
	}
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top());    // return 0
		System.out.println(minStack.getMin()); // return -2
	}
}
