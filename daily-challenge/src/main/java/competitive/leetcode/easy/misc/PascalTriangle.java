package competitive.leetcode.easy.misc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
	
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new LinkedList<>();
        
        List<Integer> prevRow = new LinkedList<>();
        prevRow.add(1);
        pascal.add(prevRow);
        
        for (int i=2; i<=numRows; i++) {
        	List<Integer> currRow = new LinkedList<>();
        	currRow.add(1);
        	Iterator<Integer> itr = prevRow.iterator();
        	Integer prev = itr.next();
        	while (itr.hasNext()) {
        		Integer curr = itr.next();
        		currRow.add(curr + prev);
        		prev = curr;
        	}
        	currRow.add(1);
        	pascal.add(currRow);
        	prevRow = currRow;
        }
        
        return pascal;
    }
    
    public static void main(String[] args) {
		System.out.println(new PascalTriangle().generate(2));
	}
}
