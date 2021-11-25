package competitive.leetcode.med.array;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

	int calls;
	Map<String, String> memo = new HashMap<>();
    private String longestPalindrome(String s, int from, int to) {
    	if (from > to) return ""; 
    	if (from == to) return String.valueOf(s.charAt(from));
    	String key = from + "," + to;
    	String m = memo.get(key);
    	if (m != null) return m;
    	calls++;
    	String option0 = null;
        if (s.charAt(from) == s.charAt(to)) {
        	String sub = longestPalindrome(s, from+1, to-1);
        	if (sub != null && (sub.length() + 2 == (to - from + 1)))
        		return s.charAt(from) + sub + s.charAt(to);
        	else 
        		option0 = sub;
        }
        String max = null;
    	
        String option1 = longestPalindrome(s, from+1, to);
    	String option2 = longestPalindrome(s, from, to-1);
    	
    	if (option1.length() > option2.length()) max = option1;
    	else max = option2;
    	
    	if (option0 != null && option0.length() > max.length()) max = option0;
    	memo.put(key, max);
        return max;
    }
    
    public String longestPalindrome(String s) {
    	String l = longestPalindrome(s, 0, s.length()-1);
    	return l;
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("abacdfgdcaba"));
	}
    
}
