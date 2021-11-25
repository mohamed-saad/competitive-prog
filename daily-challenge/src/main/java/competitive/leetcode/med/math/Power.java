package competitive.leetcode.med.math;

public class Power {
	
	private double power(double x, int n) {
		if (n == 0) return 1;
		if (n%2 == 0) {
			double v = power(x, n/2);			
			return v*v;
		} else {
			return x * power(x, n-1);
		}
	}
	
    public double myPow(double x, int n) {
    	if (x == 1 || n == 0) return 1d;		// simple cases
    	if (x == -1) return n%2==0 ? 1 : -1;	// even power is positive
    	 
    	double p = 1;
    	double v = n < 0 ? 1.0/x : x;			// negative power is fraction
    	int itr = Math.abs(n);
    	if (itr == Integer.MIN_VALUE)			// can't calculate Absolute value for it
    		itr = Integer.MAX_VALUE;
    	
    	p = power(v, itr);						// divide and conquer 
        
        if (n == Integer.MIN_VALUE)				// do additional power because of MAX != MIN
        	p = p*v;
        
        return p;
    }
    
    public static void main(String[] args) {
//		System.out.println(new Power().myPow(2, 10));
//		System.out.println(new Power().myPow(2.1, 3));
//		System.out.println(new Power().myPow(2, -2));
//		System.out.println(new Power().myPow(2, 0));
		System.out.println(new Power().myPow(1.01, Integer.MIN_VALUE));
//    	System.out.println(-2%2);
	}
    
}
