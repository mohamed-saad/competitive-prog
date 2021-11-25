package competitive.leetcode.easy.string;

public class StringToInteger {
	
    public int myAtoi(String s) {
    	long num = 0;
    	boolean startParsing = false;
    	boolean startCalculating = false;
    	Boolean negative = null;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (!startParsing && c == ' ') continue;
    		startParsing = true;
    		if (Character.isDigit(c)) {
				startCalculating = true;
    			num = num * 10 + (c - '0');
    			if (num > Integer.MAX_VALUE) return negative != null && negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    		} else if (c == '-' && negative == null && !startCalculating)
    			negative = true;
    		else if (c == '+' && negative == null && !startCalculating)
    			negative = false; 
    		else {
    			break;
    		}
    	}
    	return (int)(negative != null && negative ? num * -1 : num);
    }
    
    public static void main(String[] args) {
    	String[] test = new String[] {
    			"4193 with words",
    			"41 93 with words",
    			"   -42",
    			"   +42",
    			"   +-42",
    			"   + 42",
    			"42",
    			"-42",
    			"+42",
    			"words and 987",
    			"words and 9 87",
    	};
    	for (String s: test)
    		System.out.println(s + " ===> " + new StringToInteger().myAtoi(s));
	}
}
