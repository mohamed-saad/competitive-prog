package competitive.leetcode.hard.design;

public class Trie {
	
	private class Node {
		Node[] children = new Node[26];
		boolean endOfWord;
	}
	
	private Node head = new Node();
	
    public Trie() {
    }
    
    public void insert(String word) {
        Node itr = head;
        for (int i=0; i<word.length(); i++) {
        	char c = word.charAt(i);
        	int index = c - 'a';
        	if (itr.children[index] == null) {
        		itr.children[index] = new Node();
        	}
        	itr = itr.children[index];
        }
        itr.endOfWord = true;
    }
    
    public boolean search(String word) {
    	Node itr = head;
    	for (int i=0; i<word.length(); i++) {
    		char c = word.charAt(i);
        	int index = c - 'a';
        	if (itr.children[index] == null) return false;
        	itr = itr.children[index];
    	}
    	return itr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
    	Node itr = head;
    	for (int i=0; i<prefix.length(); i++) {
    		char c = prefix.charAt(i);
        	int index = c - 'a';
        	if (itr.children[index] == null) return false;
        	itr = itr.children[index];
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("hello");
    	System.out.println(trie.search("hell"));
    	System.out.println(trie.search("hello"));
    	System.out.println(trie.startsWith("hell"));
    	System.out.println(trie.startsWith("helx"));
    	System.out.println(trie.startsWith("hello"));
	}
}
