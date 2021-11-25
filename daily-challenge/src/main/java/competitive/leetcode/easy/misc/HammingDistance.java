package competitive.leetcode.easy.misc;

public class HammingDistance {
	
    public int hammingDistance(int x, int y) {
    	int hamming = 0;
        while (x>0 || y>0) {
        	hamming += (x & 1) ^ (y & 1);
        	x = x>>1;
        	y = y>>1;
        }
        return hamming;
    }
    
    public static void main(String[] args) {
		System.out.println(new HammingDistance().hammingDistance(15, 15));
	}
}
