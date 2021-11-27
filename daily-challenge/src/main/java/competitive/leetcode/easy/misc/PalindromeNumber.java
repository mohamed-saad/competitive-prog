package competitive.leetcode.easy.misc;

public class PalindromeNumber {

    public boolean isPalindrome(int n) {
    	if (n < 0) return false;
    	int r = 0;
    	int x = n;
    	while (x != 0) { // FIXME it is better to check half of the number only: while (x > r)
    		int d = x%10;
    		x /= 10;
    		r = r * 10 + d;
    	}
    	return r == n;
    }
    
    public boolean isPalindromeSlow(int x) {
    	if (x < 0) return false;
    	if (x < 10) return true;
    	String s = String.valueOf(x);
    	int length = s.length();
    	int mid = Math.floorDiv(length, 2);
    	for (int i=0; i<mid; i++) {
    		if (s.charAt(i) != s.charAt(length-i-1)) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(1));
		System.out.println(new PalindromeNumber().isPalindrome(10));
		System.out.println(new PalindromeNumber().isPalindrome(101));
		System.out.println(new PalindromeNumber().isPalindrome(2112));
		System.out.println(new PalindromeNumber().isPalindrome(12321));
		System.out.println(new PalindromeNumber().isPalindrome(-1));
		System.out.println(new PalindromeNumber().isPalindrome(-10));
	}
}
