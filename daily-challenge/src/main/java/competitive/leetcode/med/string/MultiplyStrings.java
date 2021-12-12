package competitive.leetcode.med.string;

import java.util.HashMap;
import java.util.Map;

public class MultiplyStrings {

	private String addStrings(String num1, String num2) {
		int carry = 0;
		StringBuilder builder = new StringBuilder();
		for (int i1 = num1.length() - 1, i2 = num2.length() - 1; i1 >= 0 || i2 >= 0; i1--, i2--) {
			int n1 = i1 < 0 ? 0 : num1.charAt(i1) - '0';
			int n2 = i2 < 0 ? 0 : num2.charAt(i2) - '0';
			int s = n1 + n2 + carry;
			carry = s / 10;
			builder.append(s % 10);
		}
		if (carry != 0)
			builder.append(carry);
		return builder.reverse().toString();
	}
	
    public String multiplySlow(String num1, String num2) {
    	if (num1.length() > num2.length()) {
    		String temp = num1;
    		num1 = num2;
    		num2 = temp;
    	}
    	
    	String allMul = "0";
    	int level = 0;
    	for (int n1=num1.length()-1; n1>=0; n1--) {
        	level++;
    		int d1 = num1.charAt(n1) - '0';
    		if (d1 == 0) continue;
    		StringBuilder mul = new StringBuilder();
    		int carry = 0;
        	for (int z=1; z<level; z++) 
        		mul.append('0');
    		for (int n2=num2.length()-1; n2>=0; n2--) {
        		int d2 = num2.charAt(n2) - '0';
        		int m = d1 * d2 + carry;
        		carry = m / 10;
        		mul.append(m % 10);
        	}
    		if (carry != 0)
    			mul.append(carry);
        	allMul = addStrings(allMul, mul.reverse().toString());
    	}
    	return allMul;
    }
    
    public String multiply(String p1, String p2) {
    	String num1, num2;
    	if (p1.length() > p2.length()) {
    		String temp = p1;
    		num1 = p2;
    		num2 = temp;
    	} else {
    		num1 = p1;
    		num2 = p2;
    	}
    	String[] multiplications = new String[num1.length()];
    	Map<Character, String> cache = new HashMap<Character, String>();
    	cache.put('0', "0");
    	for (int n1=0; n1<num1.length(); n1++) {
    		multiplications[n1]=
				cache.computeIfAbsent(num1.charAt(num1.length()-1-n1), key -> {
	        		int d1 = key - '0';
	        		StringBuilder mul = new StringBuilder();
	        		int carry = 0;
	        		for (int n2=num2.length()-1; n2>=0; n2--) {
	        			int d2 = num2.charAt(n2) - '0';
	        			int m = d1 * d2 + carry;
	        			carry = m / 10;
	        			mul.append(m % 10);
	        		}
	        		if (carry != 0)
	        			mul.append(carry);
	        		return mul.toString();
	        	});
    	}
    	
		StringBuilder result = new StringBuilder();
    	int maxDigits = multiplications[multiplications.length-1].length() + num1.length() - 1;
    	int carry = 0;
		for (int i=0; i<maxDigits; i++) {
			int s = carry;
			for (int j=0; j<multiplications.length; j++) {
				int index = i-j;
				s += index < 0 || index >= multiplications[j].length()  ? 0 : multiplications[j].charAt(index) - '0';
			}
			carry = s / 10;
			result.append(s % 10);
		}
		if (carry != 0)
			result.append(carry);
		return result.reverse().toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("999", "999"));
		System.out.println(new MultiplyStrings().multiply("123", "11"));
		System.out.println(new MultiplyStrings().multiply("123", "0"));
		System.out.println(new MultiplyStrings().multiply("123", "101"));
		System.out.println(new MultiplyStrings().multiply("123", "456"));
		System.out.println(new MultiplyStrings().multiply("2", "3"));
		System.out.println(new MultiplyStrings().multiply("140", "721"));
	}
    
}
