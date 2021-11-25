package competitive.leetcode.med.math;

public class Sqrt {

    public int mySqrt(int x) {
    	if (x == 0) return 0;
    	if (x <= 3) return 1;
    	
        for (int i=2; i<=x; i++) {		// FIXME better to use binary search on the range 2 to x 
        	int v = i*i;
        	if (v == x) return i;
        	if (v > x || // exceed the number 
        		v < 0)	 // overflow
        		return i-1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
		System.out.println(new Sqrt().mySqrt(0));
	}
}
