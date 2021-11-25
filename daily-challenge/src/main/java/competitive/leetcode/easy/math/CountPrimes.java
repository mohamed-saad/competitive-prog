package competitive.leetcode.easy.math;

public class CountPrimes {
	
    public int countPrimes(int n) {
    	if (n<=2) return 0;
    	int counter = 0;
    	
    	boolean[] notPrime = new boolean[n];

    	int maxPrime = (int)Math.sqrt(n);
    	for (int i=2; i<=maxPrime; i++) {
    		if (notPrime[i]) continue;
    		for (int j=i*i; j<n; j+=i) 
    			notPrime[j] = true;
    	}
    	
    	for (int i=2; i<notPrime.length; i++) {
    		if (!notPrime[i]) {
    			counter++;
    		}
    	}
    	
    	return counter;
    }
    
    public static void main(String[] args) {
		System.out.println("Count=" + new CountPrimes().countPrimes(1000000));
	}
    
}
