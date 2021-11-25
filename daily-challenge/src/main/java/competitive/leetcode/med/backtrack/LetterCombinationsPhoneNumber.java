package competitive.leetcode.med.backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

	private Map<Character, char[]> keyMappings = new HashMap<>();
	
	public LetterCombinationsPhoneNumber() {
		keyMappings.put('2', new char[] {'a','b','c'});
		keyMappings.put('3', new char[] {'d','e','f'});
		keyMappings.put('4', new char[] {'g','h','i'});
		keyMappings.put('5', new char[] {'j','k','l'});
		keyMappings.put('6', new char[] {'m','n','o'});
		keyMappings.put('7', new char[] {'p','q','r','s'});
		keyMappings.put('8', new char[] {'t','u','v'});
		keyMappings.put('9', new char[] {'w','x','y','z'});
	}
	
	
	private void letterCombinations(String digits, int index, String prefix, List<String> results) {
		if (index >= digits.length()) return;
		char d = digits.charAt(index);
		boolean add = (index == digits.length()-1);
		for (char letter: keyMappings.get(d))
			if (add)
				results.add(prefix + letter);
			else
				letterCombinations(digits, index+1, prefix + letter, results);
	}
	
    public List<String> letterCombinations(String digits) {
        List<String> results = new LinkedList<>();
        letterCombinations(digits, 0, "", results);
        return results;
    }
    
    public static void main(String[] args) {
		System.out.println(new LetterCombinationsPhoneNumber().letterCombinations("23"));
	}
    
}
