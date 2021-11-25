package competitive.leetcode.easy.math;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
    	if (n <= 0) return false;
    	if (n == 1) return true;
    	if (n%3 != 0) return false;
    	return isPowerOfThree(n/3);
    }
    
    public static void main(String[] args) {
		System.out.println(new PowerOfThree().isPowerOfThree(81));
	}
    
}
