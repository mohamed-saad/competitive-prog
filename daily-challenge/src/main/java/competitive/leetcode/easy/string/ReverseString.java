package competitive.leetcode.easy.string;

public class ReverseString {

    public void reverseString(char[] s) {
    	int mid = s.length/2;
    	int last = s.length-1;
    	for (int i=0; i<mid; i++) {
    		char temp = s[i];
    		s[i] = s[last-i];
    		s[last-i] = temp;
    	}
    }
}
