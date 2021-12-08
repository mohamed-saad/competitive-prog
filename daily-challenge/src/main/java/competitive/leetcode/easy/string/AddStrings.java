package competitive.leetcode.easy.string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
    	int carry = 0;
    	StringBuilder builder = new StringBuilder();
    	for(int i1=num1.length()-1, i2=num2.length()-1; i1 >=0 || i2 >=0; i1--, i2--) {
    		int n1 = i1 < 0 ? 0 : num1.charAt(i1) - '0';
    		int n2 = i2 < 0 ? 0 : num2.charAt(i2) - '0';
    		int s = n1 + n2 + carry;
    		carry = s / 10;
    		builder.append(s % 10);
    	}
    	if (carry != 0) builder.append(carry);
    	return builder.reverse().toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new AddStrings().addStrings("123", "456"));
		System.out.println(new AddStrings().addStrings("123", "789"));
		System.out.println(new AddStrings().addStrings("123", "999"));
		System.out.println(new AddStrings().addStrings("123", "9"));
		System.out.println(new AddStrings().addStrings("123", "98"));
		System.out.println(new AddStrings().addStrings("0", "0"));
		System.out.println(new AddStrings().addStrings("456", "77"));
		System.out.println(new AddStrings().addStrings("123", "11"));
	}
    
}
