package competitive.mit.lcs;

public class LCSImpl implements LCS {

	private String[][] memo;
	private int calls = 0;
	
	private String getLongestCommonSequence(char[] a, char[] b, int indexA, int indexB) {
		if (indexA >= a.length || indexB >= b.length) return "";
		if (memo[indexA][indexB] != null) return memo[indexA][indexB];
		calls++;
		if (a[indexA] == b[indexB]) {
			return memo[indexA][indexB] = a[indexA] + getLongestCommonSequence(a, b, indexA + 1, indexB + 1);
		}
		String lcs1 = getLongestCommonSequence(a, b, indexA+1, indexB);
		String lcs2 = getLongestCommonSequence(a, b, indexA, indexB+1);
		return memo[indexA][indexB] = lcs1.length() > lcs2.length() ? lcs1 : lcs2; 
	}

	@Override
	public String getLongestCommonSequence(char[] a, char[] b) {
		memo = new String[a.length][b.length];
		String lcs= getLongestCommonSequence(a, b, 0, 0);
		System.out.println("calls " + calls);
		return lcs;
	}

}
