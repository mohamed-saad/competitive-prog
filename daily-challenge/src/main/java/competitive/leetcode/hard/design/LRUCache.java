package competitive.leetcode.hard.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private class Node {
		Node next;
		Node prev;
		int key;
		int value;
		
		Node(int key, int value, Node next, Node prev) {
			this.key = key;
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return "(" + key + ":" + value + ")->" + next;
		}
	}
	
	private Map<Integer, Node> cache = new HashMap<>();
	private int capacity;
	private Node head;
	private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        if (node.prev != null) {
        	node.prev.next = node.next;
        	if (node.next != null) {
        		node.next.prev = node.prev;
        	}
        	if (tail == node && node.prev != null) {
        		tail = node.prev;
        	}
        	node.next = head;
        	node.prev = null;
        	if (head != null)
        		head.prev = node;
        	head = node;
        }
        return node.value;
    }
    
    public void put(int key, int value) {
    	if (get(key) != -1) {
    		cache.get(key).value = value;
    	} else {
    		if (cache.size() == capacity) {
    			cache.remove(tail.key);
    			if (tail.prev != null) {
    				tail.prev.next = null;
    			}
    			tail = tail.prev;
    		}
    		Node node = new Node(key, value, head, null);
    		if (head != null)
    			head.prev = node;
    		if (tail == null)
    			tail = node;
    		head = node;
    		cache.put(key, node);
    	}
    }
	
	public static void main(String[] args) {
		{
			LRUCache cache = new LRUCache(4);
			cache.put(1, 10);
			cache.put(2, 20);
			cache.put(3, 30);
			cache.put(4, 40);
			System.out.println(cache.get(1));
			System.out.println(cache.get(2));
			System.out.println(cache.get(1));
			cache.put(5, 50);
			cache.put(6, 60);
			System.out.println(cache.get(1));
			System.out.println(cache.get(2));
			System.out.println(cache.get(3));
			System.out.println(cache.get(4));
			System.out.println("------------------------");
		}
		
		{
			LRUCache lRUCache = new LRUCache(2);
			lRUCache.put(1, 1); // cache is {1=1}
			lRUCache.put(1, 10); // cache is {1=1}
			lRUCache.put(2, 2); // cache is {1=10, 2=2}
			System.out.println(lRUCache.get(1));    // return 10
			lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=10, 3=3}
			System.out.println(lRUCache.get(2));    // returns -1 (not found)
			lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
			System.out.println(lRUCache.get(1));    // return -1 (not found)
			System.out.println(lRUCache.get(3));    // return 3
			System.out.println(lRUCache.get(4));    // return 4
			System.out.println("------------------------");
		}
		
		{
			LRUCache lRUCache = new LRUCache(2);
			lRUCache.put(2, 1);
			lRUCache.put(2, 2);
			System.out.println(lRUCache.get(2));
			lRUCache.put(1, 1);
			lRUCache.put(4, 1);
			System.out.println(lRUCache.get(2));
			System.out.println("------------------------");
		}
	}
	
}
