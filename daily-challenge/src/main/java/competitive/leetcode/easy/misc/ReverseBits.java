package competitive.leetcode.easy.misc;

public class ReverseBits {
	
    public int reverseBits(int n) {
        int reverse = 0;
        for(int i=0; i<32; i++) {
        	int bit = n & 1;
        	reverse = reverse<<1;
        	reverse |= bit;
        	n = n>>>1;
        }
        return reverse;
    }
    
    public static void main(String[] args) {
		System.out.println(new ReverseBits().reverseBits(-3));
	}
    
}
