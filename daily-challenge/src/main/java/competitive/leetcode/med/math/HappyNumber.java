package competitive.leetcode.med.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	private int sumSquares(int n) {
		int sum = 0;
		while (n != 0) {
			int d = n%10;
			sum += d*d;
			n = n/10;
		}
		System.out.println(sum);
		return sum;
	}
	
    public boolean isHappy(int n) {
        Set<Integer> prev = new HashSet<>();
        int s = n;
        do {
        	s = sumSquares(s);
        	if (!prev.add(s)) // exists before 
        		return false; // cycle
        } while (s!=1);
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(Integer.MAX_VALUE));
	}
    
}
