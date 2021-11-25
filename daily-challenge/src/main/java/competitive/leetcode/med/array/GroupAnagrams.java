package competitive.leetcode.med.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> groups = new HashMap<>();
    	for (String str: strs) {
    		byte[] groupKey = new byte[26];
    		for (int i=0; i<str.length(); i++) {
    			groupKey[(str.charAt(i)-'a')]++;
    		}
    		groups.computeIfAbsent(new String(groupKey), k -> new LinkedList<>()).add(str);
    	}

    	List<List<String>> result = new LinkedList<>();
    	result.addAll(groups.values());
    	return result;
    }
}
