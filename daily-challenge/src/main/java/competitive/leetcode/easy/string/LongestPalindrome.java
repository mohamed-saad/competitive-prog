package competitive.leetcode.easy.string;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (Character.isUpperCase(c)) upper[c-'A']++;
        	else lower[c-'a']++;
        }
        int longest = 0;
        boolean odd = false;;
        for (int i=0; i<26; i++) {
        	if ((upper[i]&1) == 0) longest += upper[i];
        	else {
        		longest += upper[i]-1;
        		odd = true;
        	}
        	if ((lower[i]&1) == 0) longest += lower[i];
        	else {
        		longest += lower[i]-1;
        		odd = true;
        	}
        }
        if (odd) longest++;
        return longest ;
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("bb"));
		System.out.println(new LongestPalindrome().longestPalindrome("bB"));
		System.out.println(new LongestPalindrome().longestPalindrome("a"));
		System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
		System.out.println(new LongestPalindrome().longestPalindrome("bbaa"));
		System.out.println(new LongestPalindrome().longestPalindrome("bbBBcccddd"));
	}
    
}
