package competitive.leetcode.med.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {

	private Map<Integer, Integer> map = new HashMap<>();
	private ArrayList<Integer> values = new ArrayList<>();
		
    public RandomizedSet() {
    }
    
    public boolean insert(int val) {
    	if (map.containsKey(val)) return false;
    	map.put(val, values.size());
    	values.add(val);
    	return true;
    }
    
    public boolean remove(int val) {
    	Integer index = map.remove(val);
    	if (index == null) return false;
    	boolean lastElement = index == values.size()-1; // is it the last element
    	if (!lastElement) {
    		Integer last = values.remove(values.size()-1);	// get last element
    		values.set(index, last);
    		map.put(last, index);
    	} else {
    		values.remove(index);
    	}
    	return true;
    }
    
    public int getRandom() {
    	int index = (int)(Math.random()*values.size());
    	return values.get(index);
    }
    
    public static void main(String[] args) {
    	RandomizedSet randomizedSet = new RandomizedSet();
    	randomizedSet.insert(1);
    	randomizedSet.remove(2);
    	randomizedSet.insert(2);
    	System.out.println(randomizedSet.getRandom());
    	randomizedSet.remove(1);
    	randomizedSet.insert(2);
    	System.out.println(randomizedSet.getRandom());
	}
}
