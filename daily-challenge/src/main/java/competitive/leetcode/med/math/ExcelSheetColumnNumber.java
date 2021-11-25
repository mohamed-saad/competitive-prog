package competitive.leetcode.med.math;

public class ExcelSheetColumnNumber {
	
    public int titleToNumber(String columnTitle) {
    	int value = 0;
    	for (int i=0; i<columnTitle.length(); i++) {
    		char c = columnTitle.charAt(i);
    		int index = c - 'A' + 1;
    		value = value * 26 + index;
    	}
    	return value;
    }
    
    public static void main(String[] args) {
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("C"));
	}
}
