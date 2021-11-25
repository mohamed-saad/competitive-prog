package competitive.leetcode.easy.misc;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(' || c == '{' || c == '[' ) 
        		stack.push(c);
        	else {
        		if (stack.isEmpty()) return false;
        		char o = stack.pop();
        		boolean valid = (o == '(' && c == ')' || o == '{' && c == '}' || o == '[' && c == ']' );
        		if (!valid) return false;
        	}
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("{[]}"));
	}
    
}
