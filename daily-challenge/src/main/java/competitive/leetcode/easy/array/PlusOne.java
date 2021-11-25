package competitive.leetcode.easy.array;

import java.util.Arrays;

public class PlusOne {
	
    public int[] plusOne(int[] digits) {
    	boolean carry = true;
    	for (int i=digits.length-1; i>=0; i--) {
    		if (carry) {	// if we have carry
    			carry = digits[i] == 9;
    			digits[i] =  carry ? 0 : digits[i] + 1;
    		} else {
    			return digits;
    		}
    	}
    	if (carry) {
    		int[] result = new int[digits.length+1];
    		result[0] = 1;
    		return result;
    	} else {
    		return digits;
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new PlusOne().plusOne(new int[] {0})));
	}
    
}
