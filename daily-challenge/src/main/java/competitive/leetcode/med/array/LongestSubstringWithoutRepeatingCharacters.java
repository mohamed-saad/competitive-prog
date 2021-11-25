package competitive.leetcode.med.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
    public int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> lastOccurance = new HashMap<>();
    	int max = 0;
    	int currWindowStart = 0;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		Integer index = lastOccurance.get(c);
    		if (index != null && index >= currWindowStart) {
    			currWindowStart = (index+1);
    		}
			lastOccurance.put(c, i);
			int currWindowSize = i - currWindowStart + 1;
    		if (currWindowSize > max) max = currWindowSize;
    	}
    	return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
	}
}
