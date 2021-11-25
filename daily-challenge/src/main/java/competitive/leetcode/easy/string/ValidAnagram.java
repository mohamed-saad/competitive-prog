package competitive.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagramUnicode(String s, String t) {
    	if (s.length() != t.length()) return false;
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<s.length(); i++)
        	freq.compute(s.charAt(i), (k,v) -> v == null ? 1 : v+1);
        for (int i=0; i<t.length(); i++) {
        	freq.compute(t.charAt(i), (k,v) -> 
        		v == null ? 
        				new Integer(-1) 
    				 : (v == 1 ? null : new Integer(v-1))					
        	);
        }
        return freq.isEmpty();
    }
    
    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()) return false;
    	int[] freq = new int[26];
        for (int i=0; i<s.length(); i++) {
        	freq[s.charAt(i)-'a']++;
        	freq[t.charAt(i)-'a']--;
        }
        for (int i=0; i<freq.length; i++)
        	if (freq[i] != 0) return false;
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
	}
}
