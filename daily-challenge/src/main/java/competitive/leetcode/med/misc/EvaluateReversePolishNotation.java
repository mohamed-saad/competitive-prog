package competitive.leetcode.med.misc;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
	
    public int evalRPN(String[] tokens) {
    	Deque<Integer> stack = new LinkedList<>();
    	
    	for (String o: tokens) {
    		if (o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/")) {
    			int o1 = stack.pop(); 
    			int o2 = stack.pop(); 
    			switch (o) {
	    			case "+": stack.push(o2 + o1); break;
	    			case "-": stack.push(o2 - o1); break;
	    			case "*": stack.push(o2 * o1); break;
	    			case "/": stack.push(o2 / o1); break;
    			}
    		} else {
    			stack.push(Integer.parseInt(o));
    		}
    	}
    	
    	return stack.pop();
    }
    
    public static void main(String[] args) {
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"10"}));
	}
}
