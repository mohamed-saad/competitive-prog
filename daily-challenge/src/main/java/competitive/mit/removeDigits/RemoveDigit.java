package competitive.mit.removeDigits;

public class RemoveDigit {

	private int minimize(int[] number, int digits, int from, int base) {
		if (from == number.length || digits == number.length-from) return 0;	// remove all remains
		
		int without = number[from] * base + minimize(number, digits, from+1, base/10);	// keep the current number
		int with = digits == 0 ? Integer.MAX_VALUE : minimize(number, digits-1, from+1, base);	// drop the current number
		
		return Math.min(with, without);
	}
	
	public int minimize(String number, int digits) {
//		return minimize(new int[] { 1, 4, 8, 2 }, 1, 0, 100);
		return minimize(new int[] { 3, 7, 2, 1, 8, 1 }, 1, 0, 10000);
	}
	
	public static void main(String[] args) {
		System.out.println(new RemoveDigit().minimize("", 1));
	}
}
