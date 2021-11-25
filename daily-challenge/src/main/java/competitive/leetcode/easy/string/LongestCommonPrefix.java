package competitive.leetcode.easy.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String ref = strs[0];
        StringBuilder prefix = new StringBuilder();
        for (int i=0; i<ref.length(); i++) {
        	char c = ref.charAt(i);
        	for (int s=1; s<strs.length; s++) {
        		if (i >= strs[s].length() || strs[s].charAt(i) != c) {
        			return prefix.toString();
        		}
        	}
        	prefix.append(c);
        }
        return prefix.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"flower","","flight"}));
	}
}
