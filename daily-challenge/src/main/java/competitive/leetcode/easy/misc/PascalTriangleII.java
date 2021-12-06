package competitive.leetcode.easy.misc;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRow1(int rowIndex) {
    	List<Integer> list = new LinkedList<>();
    	if (rowIndex == 0) {
    		list.add(1);
    		return list;
    	}
    	List<Integer> pre = getRow(rowIndex-1);
    	int p = 0;
    	for (Integer n: pre) {
    		list.add(p + n);
    		p = n;
    	}
    	list.add(1);
    	return list;
    }
    
    public void getPascalRow(int rowIndex, int[] row) {
    	if (rowIndex == 0) {
    		row[0] = 1;
    		return;
    	}
    	getPascalRow(rowIndex-1, row);
    	int p = 0;
    	for (int i=0; i<rowIndex; i++) {
    		int t = row[i];
    		row[i] = p + row[i];
    		p = t;
    	}
    	row[rowIndex] = 1;
	}
    
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new LinkedList<>();
    	int[] row = new int[rowIndex+1];
    	getPascalRow(rowIndex, row);
    	for (int i: row)
    		list.add(i);
    	return list;
    }
    
    public static void main(String[] args) {
		System.out.println(new PascalTriangleII().getRow(4));
	}
    
}
