package competitive.leetcode.med.list;

public class MyLinkedList {

	private class Node {
		int val;
		Node next;
		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "(" + val + ")->" + next;
		}
	}

	private Node head;
	private Node tail;
	
    public MyLinkedList() {
    }
    
    public int get(int index) {
    	if (index < 0 || head == null) return -1;
    	Node itr = head;
    	for (int i=0; i<index; i++) {
    		itr = itr.next;
    		if (itr == null) return -1;
    	}
    	return itr.val;
    }
    
    public void addAtHead(int val) {
    	head = new Node(val, head);
    	if (head.next == null) tail = head;
    }
    
    public void addAtTail(int val) {
    	Node last = tail;
    	tail = new Node(val, null);
    	if (last != null) last.next = tail;
    	else head = tail;
    }
    
    public void addAtIndex(int index, int val) {
    	if (index < 0) return;
    	if (index == 0) addAtHead(val);
    	else if (head != null){
    		Node pre = head;
        	Node itr = head.next;
        	for (int i=1; i<index; i++) {
        		pre = itr;
        		if (pre == null) return;	// out of index
        		itr = itr.next;
        	}
        	Node node = new Node(val, pre.next);
        	pre.next = node;
        	if (node.next == null) tail = node;
    	}
    }
    
    public void deleteAtIndex(int index) {
    	if (index < 0 || head == null) return;
    	if (index == 0) {
    		head = head.next;
    		if (head == null) tail = null;
    	} else {
    		Node pre = head;
        	Node itr = head.next;
        	for (int i=1; i<index; i++) {
        		pre = itr;
        		if (pre == null) return;	// out of index
                itr = itr.next;
        	}
            if (itr == null) return;	// out of index
        	pre.next = itr.next;
        	if (pre.next == null) tail = pre;
    	}
    }
    
    @Override
    public String toString() {
    	return String.valueOf(head);
    }

    public static void main(String[] args) {
    	{
    		MyLinkedList linkedList = new MyLinkedList();
	    	linkedList.addAtHead(20);
	    	linkedList.addAtHead(10);
	    	linkedList.addAtTail(30);
	    	linkedList.addAtTail(40);
	    	linkedList.addAtIndex(1, 15);
	    	linkedList.addAtIndex(0, 5);
	    	linkedList.addAtIndex(7, 500);
	    	linkedList.addAtIndex(6, 50);
	    	System.out.println(linkedList);
	    	linkedList.deleteAtIndex(1);
	    	System.out.println(linkedList);
	    	linkedList.deleteAtIndex(0);
	    	System.out.println(linkedList);
	    	linkedList.deleteAtIndex(0);
	    	System.out.println(linkedList);
	    	linkedList.deleteAtIndex(3);
	    	System.out.println(linkedList);
	    	linkedList.addAtTail(41);
	    	System.out.println(linkedList);
	    	linkedList.deleteAtIndex(2);
	    	System.out.println(linkedList);
	    	linkedList.deleteAtIndex(20);
	    	linkedList.deleteAtIndex(-1);
	    	System.out.println(linkedList);
	    	System.out.println(linkedList.get(-10));
	    	System.out.println(linkedList.get(0));
	    	System.out.println(linkedList.get(1));
	    	System.out.println(linkedList.get(2));
	    	System.out.println(linkedList.get(3));
	    	System.out.println(linkedList.get(4));
	    }
    	System.out.println("----------------------------");
    	{
    		MyLinkedList linkedList = new MyLinkedList();
	    	linkedList.addAtTail(40);
	    	System.out.println(linkedList.get(0));
    	}
    	System.out.println("----------------------------");
    	{
    		MyLinkedList linkedList = new MyLinkedList();
	    	linkedList.addAtIndex(1, 0);
	    	System.out.println(linkedList.get(0));
    		System.out.println(linkedList);
    	}
	}
}
