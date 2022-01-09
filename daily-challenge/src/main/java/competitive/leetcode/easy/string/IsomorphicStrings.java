package competitive.leetcode.easy.string;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Character[] mapping = new Character[255];
        for (int i=0; i<s.length(); i++) {
            Character m = mapping[s.charAt(i)];
            if (m == null) {
                mapping[s.charAt(i)] = t.charAt(i);
            } else if (!m.equals(t.charAt(i))) {
                return false;
            }
        }
        boolean[] unique = new boolean[255];
        for (int i=0; i<mapping.length; i++) {
            if (mapping[i] != null) {
                if (unique[mapping[i]]) return false;
                unique[mapping[i]] = true;
            }
        }
        return true;
    }
    
}
