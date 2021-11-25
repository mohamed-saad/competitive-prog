package competitive.leetcode.med.backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber2 {

	private Map<Character, char[]> keyMappings = new HashMap<>();
	
	public LetterCombinationsPhoneNumber2() {
		keyMappings.put('2', new char[] {'a','b','c'});
		keyMappings.put('3', new char[] {'d','e','f'});
		keyMappings.put('4', new char[] {'g','h','i'});
		keyMappings.put('5', new char[] {'j','k','l'});
		keyMappings.put('6', new char[] {'m','n','o'});
		keyMappings.put('7', new char[] {'p','q','r','s'});
		keyMappings.put('8', new char[] {'t','u','v'});
		keyMappings.put('9', new char[] {'w','x','y','z'});
	}
	
	private String digits; 
	private char[] prefix;
	private List<String> results;
	private void letterCombinations(int index) {
		if (index >= digits.length()) return;
		char d = digits.charAt(index);
		boolean add = (index == digits.length()-1);
		for (char letter: keyMappings.get(d)) {
			prefix[index] = letter;
			if (add) 
				results.add(new String(prefix));
			else
				letterCombinations(index+1);
		}
	}
	
    public List<String> letterCombinations(String digits) {
    	this.results = new LinkedList<>();
        this.digits = digits;
        this.prefix = new char[digits.length()];
        letterCombinations(0);
        return this.results;
    }
    
    public static void main(String[] args) {
		System.out.println(new LetterCombinationsPhoneNumber2().letterCombinations("23"));
	}
    
}
