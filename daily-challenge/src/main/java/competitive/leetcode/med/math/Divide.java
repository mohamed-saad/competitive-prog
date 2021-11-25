package competitive.leetcode.med.math;

public class Divide {
	
    public int divide(int dividend, int divisor) {
    	// handle some base cases
    	if (dividend == 0) return 0;
    	if (divisor == 1) return dividend;
    	if (divisor == -1) {
    		if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;	// an overflow case
    		return -1 * dividend;
    	}
    
    	// use subtraction to divide
    	boolean positiveDivident =  dividend > 0;
    	boolean positiveDivisor = divisor > 0;
    	int count = 0;
    	if (positiveDivident && positiveDivisor) {
    		while (dividend > 0) {
    			// FIXME instead of slow jump, we can do exponential jumps and narrow down with out loop
    			dividend = dividend - divisor;		 
    			count++;
    		}
    	} else if (positiveDivident && !positiveDivisor) {
    		while (dividend > 0) {
    			dividend = dividend + divisor;
    			count++;
    		}
    	} else if (!positiveDivident && positiveDivisor) {
    		while (dividend < 0) {
    			dividend = dividend + divisor;
    			count++;
    		}
    	} else if (!positiveDivident && !positiveDivisor) {
    		while (dividend < 0) {
    			dividend = dividend - divisor;
    			count++;
    		}
    	}

    	if (dividend != 0) count--;	// handle perfect division
    	
    	boolean minus = positiveDivident ^ positiveDivisor; 
    	return minus ? -1 * count : count;
    }
    
    public static void main(String[] args) {
    	
    	System.out.println(new Divide().divide(Integer.MAX_VALUE, -1));
//    	System.out.println(Integer.MIN_VALUE);
//    	System.out.println(Integer.MAX_VALUE);
//		System.out.println(new Divide().divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
//		System.out.println(new Divide().divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
//		System.out.println(new Divide().divide(Integer.MAX_VALUE, 3));
//		System.out.println(new Divide().divide(Integer.MIN_VALUE, 3));
//
//		System.out.println(new Divide().divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
//		System.out.println(new Divide().divide(Integer.MIN_VALUE, Integer.MIN_VALUE));

//    	System.out.println(new Divide().divide(2, 1));
//		System.out.println(new Divide().divide(2, -1));
//		System.out.println(new Divide().divide(-2, -1));
//		System.out.println(new Divide().divide(-2, 1));
		
    	System.out.println(new Divide().divide(10, 3));
		System.out.println(new Divide().divide(10, -3));
		System.out.println(new Divide().divide(-10, -3));
		System.out.println(new Divide().divide(-10, 3));

	}
}
