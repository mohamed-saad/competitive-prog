package competitive.leetcode.med.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TaskScheduler {

	// FIXME wrong algo
    public int leastInterval(char[] tasks, int n) {
    	// count tasks
    	Map<Character, Integer> freq = new HashMap<>();
    	for (char c: tasks) 
    		freq.compute(c, (k,v) -> v == null ? 1 : v+1);
    	char[] scheduler = new char[tasks.length * (n+1)];
    	// fill in slots using gready algo
    	int maxTime = 0;
    	for (Entry<Character, Integer> e: freq.entrySet()) {
    		int index = 0;
    		for (int i=0; i<e.getValue(); i++) {
    			while (scheduler[index] != 0) {
    				index++;
    			}
    			scheduler[index] = e.getKey();
    			if (index > maxTime) maxTime = index;
    			index+=n+1;
    		}
    	}
    	System.out.println(Arrays.toString(scheduler));
    	return maxTime+1;
    }
    
    public static void main(String[] args) {
    	char[] tasks = new char[] {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
		System.out.println(new TaskScheduler().leastInterval(tasks, 2));
	}
    
    
}
