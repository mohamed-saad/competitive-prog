package competitive.leetcode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String string) {
    	String[] mapping = new String[26];
    	Set<String> mappingR = new HashSet<>();
    	int index = 0;
    	for (int i=0; i<pattern.length(); i++) {
    		int start = index;
    		if (index >= string.length()) return false;
    		while(index < string.length() && string.charAt(index) != ' ')
    			index++;
    		char p = pattern.charAt(i);
    		String word = string.substring(start, index);
    		String w = mapping[p-'a'];
    		if (w == null) {
    			if (mappingR.contains(word)) return false;	// word mapped before to different character
    			mapping[p-'a'] = word;
    			mappingR.add(word);
    		} else if (!w.equals(word))	// mapped to different word
    			return false;
    		index++;	// skip space
    	}
    	return (index == string.length()+1);
    }
    
    public static void main(String[] args) {
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog cat"));
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog wolf"));
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat"));
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
		System.out.println(new WordPattern().wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
		System.out.println(new WordPattern().wordPattern("abba", ""));
		System.out.println(new WordPattern().wordPattern("abba", "dog dog cat cat"));
		System.out.println(new WordPattern().wordPattern("axya", "dog cat cat dog"));
		System.out.println(new WordPattern().wordPattern("a", "dog cat cat dog"));
	}
    
}
