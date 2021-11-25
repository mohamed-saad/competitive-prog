package competitive.leetcode.easy.string;

public class StrStr {
	
    private int strStr(String haystack, String needle, int startFrom) {
    	int i = 0;
    	int itr = startFrom;
    	while (itr < haystack.length() && i < needle.length()) {
    		if(haystack.charAt(itr) != needle.charAt(i)) 
    			return -1;
    		itr++;
    		i++;
    	}
    	return i == needle.length() ? startFrom : -1;
    }
	
    public int strStr(String haystack, String needle) {
    	if (needle.length() == 0) return 0;
        int startFrom = 0;
        int max = haystack.length() - needle.length() + 1;
        while(startFrom < max) {
        	int pos = strStr(haystack, needle, startFrom);
        	if (pos >= 0) return pos;
        	startFrom++;
        }
        return -1;
    }
    
//    https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
    static class KMP_String_Matching {
        void KMPSearch(String pat, String txt)
        {
            int M = pat.length();
            int N = txt.length();
      
            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int j = 0; // index for pat[]
      
            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat, M, lps);
      
            int i = 0; // index for txt[]
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                    System.out.println("Found pattern "
                                       + "at index " + (i - j));
                    j = lps[j - 1];
                }
      
                // mismatch after j matches
                else if (i < N
                         && pat.charAt(j) != txt.charAt(i)) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
        }
      
        void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0
      
            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (len != 0) {
                        len = lps[len - 1];
      
                        // Also, note that we do not increment
                        // i here
                    }
                    else // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	String haystack = "hellalollllx";
    	String needle = "AAACAAAA";
    	new KMP_String_Matching().KMPSearch(needle, haystack);
//		System.out.println(new StrStr().strStr(haystack, needle));
	}
    
}
