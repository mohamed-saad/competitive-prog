package competitive.leetcode.easy.list;

 
public class RemoveNNode {
	
	static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     
	     @Override
	    public String toString() {
	    	 return "(" + val + ")" + (next == null ? "" : "->" + next.toString());  
	    }
	}
	
	private ListNode reverse(ListNode prev, ListNode node) {
		if (node == null) return null;
		ListNode next = node.next;
		node.next = prev;
		return next == null ? node : reverse(node, next);
	}
	
    public ListNode removeNthFromEndReverse(ListNode head, int n) {
    	ListNode tail = reverse(null, head);
    	ListNode prev = null;
    	ListNode itr = tail;
        for (int i=1; i<n; i++) {
        	prev = itr;
        	itr = itr.next;
        }
        if (prev == null) {
        	tail = tail.next;
        } else {
        	prev.next = itr.next;
        }
        return reverse(null, tail);
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	// seek to node
    	ListNode itr = head;
    	for (int i=1; i<n; i++) {
    		itr = itr.next;
    	}
    	
    	// move with shift
    	ListNode prevItr2 = null;
    	ListNode itr2 = head; 
    	while(itr.next != null) {
    		itr = itr.next;
    		prevItr2 = itr2;
    		itr2 = itr2.next;
    	}
    	
    	if (prevItr2 == null) {	// deleting the head
    		return head.next;
    	}
    	
    	// delete
    	prevItr2.next = itr2.next;
    	return head;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    	System.out.println(head);
//    	ListNode tail = new RemoveNNode().reverse(null, head);
//    	System.out.println(tail);
    	System.out.println(new RemoveNNode().removeNthFromEnd(head, 5));
	}
}
