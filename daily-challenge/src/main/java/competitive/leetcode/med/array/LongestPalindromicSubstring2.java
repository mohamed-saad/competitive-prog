package competitive.leetcode.med.array;

public class LongestPalindromicSubstring2 {
    
    public String longestPalindrome(String s) {
    	int maxStart = 0;
    	int maxEnd = 0;
    	for (int i=0; i<s.length(); i++) {
    		int len1 = findPalindrome(s, i, i);	// odd palindrome centered arround 1
    		int len2 = findPalindrome(s, i, i+1); // event palindrome with i and i+1
    		if (len1 > (maxEnd - maxStart + 1)) {
    			// odd
    			maxStart = i - len1/2;
    			maxEnd = i + len1/2;
    		}
    		if (len2 > (maxEnd - maxStart + 1)) {
    			// even
    			maxStart = i - (len2-2)/2;
    			maxEnd = i + 1 + (len2-2)/2;
    		}
    	}
    	return s.substring(maxStart, maxEnd+1);
    }
    
    private int findPalindrome(String s, int i1, int i2) {
    	int len = i1==i2 ? -1 : 0;
    	while (i1 >=0 && i2 <s.length() && s.charAt(i1) == s.charAt(i2)) {
    		len+=2;
    		i1--;
    		i2++;
    	}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring2().longestPalindrome("whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone"));
	}
    
}
