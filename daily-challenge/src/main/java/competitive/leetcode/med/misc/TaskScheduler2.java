package competitive.leetcode.med.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TaskScheduler2 {

    public int leastInterval(char[] tasks, int n) {
    	// count tasks
    	Map<Character, Integer> freq = new HashMap<>();
    	for (char c: tasks) 
    		freq.compute(c, (k,v) -> v == null ? 1 : v+1);
    	// fill in slots using gready algo
    	Map<Character, Integer> lastPosition = new HashMap<>();
    	int index = 0;
    	while (!freq.isEmpty()) {
    		for (Character event: freq.keySet().toArray(new Character[0])) {
    			Integer last = lastPosition.get(event);
    			if (last != null && (index - last <= n)) 
					index = last+n+1;
    			System.out.println(event + "==> " + index);
	    		lastPosition.put(event, index);
	    		freq.compute(event, (k,v) -> v==1 ? null : v-1);
				index++;
    		}
    	}
    	return index+1;
    }
    
    public static void main(String[] args) {
//    	char[] tasks = new char[] {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
    	char[] tasks = new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'};
		System.out.println(new TaskScheduler2().leastInterval(tasks, 2));
	}
    
    
}
