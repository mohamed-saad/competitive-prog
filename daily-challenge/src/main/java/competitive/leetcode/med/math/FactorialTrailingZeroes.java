package competitive.leetcode.med.math;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
    	// zeros comes from 5*2, and there are many twos but few fives
    	// how many 5 before n
    	// how many 25 before n
    	// how many 125 before n
    	// ....
    	int f = 5;
    	int fives = 0;
    	while (f <= n) {
    		fives += n/f;
    		f = f*5;
    	}
    	return fives;
    }
    
    private long factorial(int n) {
    	long f = 1;
    	for (int i=1; i<=n; i++)
    		f *= i;
    	return f;
    }
    
    public static void main(String[] args) {
    	int num = 20;
    	System.out.println(new FactorialTrailingZeroes().factorial(num));
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(num));
	}
}
