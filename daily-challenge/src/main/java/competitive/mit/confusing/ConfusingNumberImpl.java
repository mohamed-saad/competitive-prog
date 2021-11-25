package competitive.mit.confusing;

public class ConfusingNumberImpl implements ConfusingNumber {

	private int generator(int[] nums, int limit, int v) {
		if (v > limit) return 0;
		for (int d: nums) {
			if (v == 0 && d == 0) continue;
			int number = 10 * v + d;
			if (number < limit) {
				System.out.println(number);
				generator(nums, limit, number);
			}
		}
		return 0;
	}
	
	@Override
	public int find(int n) {
		return generator(new int[] {0, 1, 6, 8, 9}, n, 0);
	}
	
	public static void main(String[] args) {
		new ConfusingNumberImpl().find(1000);
	}

}
