package competitive.leetcode.easy.math;

public class CountPrimes2 {

	private boolean isPrime(int n) {
		int maxDiv = (int)Math.sqrt(n);
		for (int i=3; i<=maxDiv; i+=2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
    public int countPrimes(int n) {
    	if (n<=2) return 0;
    	int counter = 1;
    	for (int i=3; i<n; i+=2) {
    		if (isPrime(i)) {
    			counter++;
    			System.out.println(i);
    		}
    	}
    	return counter;
    }
    
    public static void main(String[] args) {
		System.out.println("Count=" + new CountPrimes2().countPrimes(1000000));
	}
    
}
