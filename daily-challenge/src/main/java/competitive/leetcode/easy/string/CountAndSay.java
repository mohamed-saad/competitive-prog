package competitive.leetcode.easy.string;

public class CountAndSay {
	
	private String say(String n) {
		StringBuilder builder = new StringBuilder();
		int count = 1;
		for (int i=0; i<n.length()-1; i++) {
			if (n.charAt(i) == n.charAt(i+1)) {
				count++;
			} else {
				builder.append(count).append(n.charAt(i));
				count = 1;
			}
		}
		builder.append(count).append(n.charAt(n.length()-1));
		return builder.toString();
	}
	
    public String countAndSay(int n) {
    	if (n == 1) return "1";
    	return say(countAndSay(n-1));
    }
    
    public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(10));
	}
    
}
