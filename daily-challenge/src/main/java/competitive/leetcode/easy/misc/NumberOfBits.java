package competitive.leetcode.easy.misc;

public class NumberOfBits {

    public int hammingWeight(int n) {
        int bits = 0;
        while(n!=0) {
        	bits += n & 1;
        	n = n>>>1;
        }
        return bits;
    }
    
    public static void main(String[] args) {
		System.out.println(new NumberOfBits().hammingWeight(15));
	}
}
