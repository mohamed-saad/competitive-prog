package competitive.leetcode.easy.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueCharacter {
	
    public int firstUniqChar(String s) {
    	Map<Character, Boolean> freq = new LinkedHashMap<>();
    	for (int i=0; i<s.length(); i++) {
    		freq.compute(s.charAt(i), (k,v) -> v == null ? true : false);
    	}
    	for(Entry<Character,Boolean> e: freq.entrySet())
    		if (e.getValue()) return s.indexOf(e.getKey(), 0);
    	return -1;
    }
    
    public static void main(String[] args) {
		System.out.println(new UniqueCharacter().firstUniqChar("aabb"));
	}
    
}
