package competitive.leetcode.easy.string;

public class ReverseInteger {
	
    public int reverse(int x) {
    	StringBuilder num = new StringBuilder();
    	if (x < 0) num.append("-");
    	x = Math.abs(x);
    	while(x > 0) {
    		int d = x % 10;
    		x = x / 10;
    		num.append(d);
    	}
    	try {
    		return Integer.parseInt(num.toString());
		} catch (Exception e) {
			return 0;
		}
    }
    
    public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-123));
	}
}
