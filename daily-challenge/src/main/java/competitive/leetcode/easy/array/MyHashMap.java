package competitive.leetcode.easy.array;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

	class Node {
		int key;
		int value;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return key + "->" + value;
		}
	}
	
	private List<Node>[] buckets;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 16;
	private static final int LOAD_FACTOR = 4;
	
    public MyHashMap() {
    	buckets = new List[DEFAULT_CAPACITY];
    }
    
    private void resize(int newSize) {
    	List<Node>[] temp = buckets;
    	size = 0;
    	buckets = new List[newSize];
    	for (List<Node> b: temp) {
    		if (b == null) continue;
    		for (Node n: b) 
    			put(n.key, n.value);
    	}
    }
    
    public void put(int key, int value) {
    	if (size == buckets.length * LOAD_FACTOR) {
    		resize(buckets.length * 2);
    	}
    	
        int h = hash(key);
    	if (buckets[h] == null)
        	buckets[h] = new LinkedList<>();
    	int index = 0;
    	for (Node node: buckets[h]) {
    		if (node.key == key) {
    			node.value = value;
    			return;
    		} else if (node.key > key) {
    			break;
    		}
    		index++;
    	}
    	size++;
    	buckets[h].add(index, new Node(key, value));
    }
    
    public int get(int key) {
    	int h = hash(key);
    	if (buckets[h] == null) return -1;
    	for (Node node: buckets[h]) {
    		if (node.key == key) {
    			return node.value;
    		} else if (node.key > key) {
    			break;
    		}
    	}
    	return -1;
    }
    
    public void remove(int key) {
    	int h = hash(key);
    	if (buckets[h] == null) return;
    	int index = 0;
    	for (Node node: buckets[h]) {
    		if (node.key == key) {
    			buckets[h].remove(index);
    			size--;
    			break;
    		} else if (node.key > key) {
    			break;
    		}
    		index++;
    	}
    	
    	if (buckets.length > DEFAULT_CAPACITY && size * LOAD_FACTOR < buckets.length) {
    		resize(buckets.length / 2);
    	}
    }
    
    private int hash(int key) {
    	return key % buckets.length;
    }
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	for (int i=0; i<buckets.length; i++) {
    		if (buckets[i] == null) builder.append("[--]");
    		else builder.append(buckets[i]);
    		builder.append("\n");
    	}
    	return builder.toString();
    }
    
    public static void main(String[] args) {
    	{
    		MyHashMap myHashMap = new MyHashMap();
    		myHashMap.put(1, 1); // The map is now [[1,1]]
    		myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    		System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
    		System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    		myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    		System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
    		myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    		System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    		System.out.println("\n\n" + myHashMap);
    	}
    	{
    		MyHashMap myHashMap = new MyHashMap();
    		for (int i=0; i<1000; i++) {
    			myHashMap.put(i, i);
    		}
    		System.out.println("\n\n" + myHashMap);
    	}
    	{
    		MyHashMap myHashMap = new MyHashMap();
    		for (int i=1000; i>=0; i--) {
    			myHashMap.put(i, i);
    		}
    		System.out.println("\n\n" + myHashMap);
    	}
    	{
    		MyHashMap myHashMap = new MyHashMap();
    		for (int i=0; i<1000; i++) {
    			myHashMap.put(i, i);
    		}
    		for (int i=0; i<1000; i++) {
    			myHashMap.remove(i);
    		}
    		System.out.println("\n\n" + myHashMap);
    	}
	}
    
}
