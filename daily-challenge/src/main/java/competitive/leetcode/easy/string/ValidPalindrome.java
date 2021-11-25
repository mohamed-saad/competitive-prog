package competitive.leetcode.easy.string;

import java.util.ArrayDeque;
import java.util.Queue;

public class ValidPalindrome {

    public boolean isPalindromeNoramlize(String s) {
    	StringBuilder normalized = new StringBuilder();
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (c != ' ' && Character.isLetterOrDigit(c)) 
    			normalized.append(Character.toLowerCase(c));
    	}
    	String noramlizedString = normalized.toString();
    	int mid = noramlizedString.length()/2;
    	int last = noramlizedString.length() - 1;
    	for (int i=0; i<mid; i++)
    		if (noramlizedString.charAt(i) != noramlizedString.charAt(last - i)) return false;
    	return true;
    }
    
    public boolean isPalindromeQueue(String s) {
    	int countPunc = 0;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (c == ' ' || !Character.isLetterOrDigit(c)) 
    			countPunc++;
    	}
    	int mid = (s.length() - countPunc) / 2;
    	Queue<Character> queue = new ArrayDeque<Character>(mid);
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (c != ' ' && Character.isLetterOrDigit(c)) {
    			queue.add(Character.toLowerCase(c));
    			if (queue.size() == mid) break;
    		}
    	}
    	for (int i=s.length()-1; i>0; i--) {
    		char c = s.charAt(i);
    		if (c != ' ' && Character.isLetterOrDigit(c)) {
    			if (Character.toLowerCase(c) != queue.remove()) return false;
    			if (queue.isEmpty()) break;
    		}
    	}
    	return true;
    }
    
    public boolean isPalindrome(String s) {
    	int left = 0;
    	int right = s.length()-1;
    	while(true) {
    		while(left < s.length() && (s.charAt(left) == ' ' || !Character.isLetterOrDigit(s.charAt(left))))
    			left++;
    		while(right >= 0 && (s.charAt(right) == ' ' || !Character.isLetterOrDigit(s.charAt(right))))
    			right--;
    		if (left >= right) return true;
    		if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
    		left++;
    		right--;
    	}
    }

    public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome( "A man, a plan, a canal: Panama"));
	}
    
}
