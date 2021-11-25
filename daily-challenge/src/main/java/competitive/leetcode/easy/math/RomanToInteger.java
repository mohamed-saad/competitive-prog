package competitive.leetcode.easy.math;

public class RomanToInteger {

    public int romanToInt(String s) {
    	int[] values = new int[26];
    	values['I'-'A'] = 1;
    	values['V'-'A'] = 5;
    	values['X'-'A'] = 10;
    	values['L'-'A'] = 50;
    	values['C'-'A'] = 100;
    	values['D'-'A'] = 500;
    	values['M'-'A'] = 1000;
    	
    	int value = 0;
    	for (int i=0; i<s.length(); i++) {
    		int v = values[s.charAt(i)-'A'];
    		if (i == s.length()-1	// last letter 
    				|| v >= values[s.charAt(i+1)-'A'])	// less than next
    			value += v;
    		else
    			value -= v;
    	}

    	return value;
    }
    
    public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
	}
}
