package competitive.leetcode.hard.list;

public class ReverseNodesKGroup {

	 private static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     
	     @Override
	    public String toString() {
	    	 return "(" + val + ")";// + (next == null ? "" : "->" + next.toString());  
	    }
	 }
	 
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k == 1) return head;
    	ListNode itr = head;
		ListNode preStart = null;
		ListNode newHead = null;
		ListNode end = null;
		ListNode start = null;
    	while(itr != null) {
    		// find group
    		start = itr;
    		int i = 0;
    		for (; i<k && itr != null; i++) {
    			end = itr;
    			itr = itr.next;
    		}
    		if (i != k) break;
    		System.out.println("reverse " + start.val + " till " + end.val + " pre is:" + preStart);
    		
    		// reverse group
    		ListNode p = start;
    		ListNode n = start.next;
    		for (i=1; i<k; i++) {
    			ListNode t = n.next;
    			n.next = p;
    			p = n;
    			n = t;
    		}
    		
    		if (newHead == null) {
    			newHead = end;
    		} else {
    			preStart.next = end;
    		}
    		preStart = start;
    	}
    	if (preStart == start)	// reverse whole list
    		preStart.next = null;
    	else
    		preStart.next = start;	
    	return newHead;
    }
    
    public static String toString(ListNode head) {
    	StringBuilder builder = new StringBuilder();
    	ListNode itr = head;
    	while(itr != null) {
    		builder.append("(" + itr.val + ")->");
    		itr = itr.next;
    	}
    	return builder.toString();
    }
    
    public static void main(String[] args) {
    	ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(10)))))));
    	System.out.println(list);
    	System.out.println(toString(new ReverseNodesKGroup().reverseKGroup(list, 7)));
	}
}
