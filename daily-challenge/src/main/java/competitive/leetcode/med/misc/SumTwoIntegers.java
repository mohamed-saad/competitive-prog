package competitive.leetcode.med.misc;

public class SumTwoIntegers {
    
	public int getSum(int a, int b) {
		int sum = 0;
		boolean carry = false;
		int currentBit = 0;
		while (a != 0 || b != 0) {
			boolean bitA = (a & 1) == 1;
			boolean bitB = (b & 1) == 1;
			boolean bitSum = bitA ^ bitB ^ carry;
			carry = (bitA && bitB) | (carry && (bitA ^ bitB));
			if (bitSum)
				sum |= 1<<currentBit;
			currentBit++;
			a = a>>1;
			b = b>>1;
		}
		if (carry)
			sum |= 1<<currentBit;
		return sum;
    }
	
	public static void main(String[] args) {
		System.out.println(new SumTwoIntegers().getSum(1, 15));
	}
	
}
