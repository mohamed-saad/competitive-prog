package competitive.leetcode.easy.list;

public class RemoveLinkedListElements {

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
	
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode newHead = head;
        while(newHead != null && newHead.val == val) {
            newHead = newHead.next;
        }
        if (newHead == null) return newHead;
        
        ListNode pre = newHead;
        ListNode itr = newHead.next;
        while(itr != null) {
            if (itr.val == val) {
                pre.next = itr.next; // delete
            } else {
                pre = itr; // move forward
            }
            itr = itr.next;
        }
        return newHead;
    }
}
