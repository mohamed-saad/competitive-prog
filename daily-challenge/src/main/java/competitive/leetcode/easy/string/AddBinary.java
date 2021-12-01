package competitive.leetcode.easy.string;

public class AddBinary {
	
    public String addBinary(String a, String b) {
    	/*
				C A B   S C
				0 0 0   0 0
				0 0 1   1 0
				0 1 0   1 0
				0 1 1   0 1
				1 0 0   1 0
				1 0 1   0 1
				1 1 0   0 1 
				1 1 1   1 1
    	 */

    	int itrA = a.length()-1;
    	int itrB = b.length()-1;
    	boolean carry = false;
    	StringBuilder sum = new StringBuilder();
    	boolean hasNextA, hasNextB;
    	while((hasNextA = (itrA >= 0)) | (hasNextB = (itrB >= 0))) {
    		boolean a1 = hasNextA && (a.charAt(itrA) == '1'); 
    		boolean b1 = hasNextB && (b.charAt(itrB) == '1'); 
    		
    		sum.append(a1 ^ b1 ^ carry ? '1' : '0');   
    		carry = a1 && b1 || a1 && carry || b1 && carry;
    		
    		itrA--;
    		itrB--;
    	}
    	
    	if (carry) sum.append('1');
    	
    	return sum.reverse().toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1", "11111"));
		System.out.println(new AddBinary().addBinary("1", "00000"));
		System.out.println(new AddBinary().addBinary("0", "11111"));
		System.out.println(new AddBinary().addBinary("1010", "0001"));
		System.out.println(new AddBinary().addBinary("1010", "1"));
		System.out.println(new AddBinary().addBinary("1010", "0101"));
		System.out.println(new AddBinary().addBinary("1010", "101"));
	}
}
