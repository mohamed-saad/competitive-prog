package competitive.leetcode.med.backtrack;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	
	private List<String> result;
	private char[] buffer;
	private void generateParenthesis(int index, int openedSoFar) {
		if (index == buffer.length) {
			if (openedSoFar == 0)
				result.add(new String(buffer));
			return;
		}
		
		if (buffer.length - index > openedSoFar) {
			buffer[index] = '(';	// open new one
			generateParenthesis(index+1, openedSoFar+1);
		}
		
		if (openedSoFar > 0) {
			buffer[index] = ')';	// close one
			generateParenthesis(index+1, openedSoFar-1);
		}
	}
	
    public List<String> generateParenthesis(int n) {
    	result = new LinkedList<>(); 
    	buffer = new char[n*2];
    	generateParenthesis(0, 0);
        return result;
    }
    
    public static void main(String[] args) {
    	GenerateParentheses gen = new GenerateParentheses();
		System.out.println(gen.generateParenthesis(1));
	}
}
