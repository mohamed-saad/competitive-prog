package competitive.leetcode.easy.list;

public class LinkedListCycle {
	
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
	
    public boolean hasCycle(ListNode head) {
    	if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) return true;
        }
        return false;
    }
}
