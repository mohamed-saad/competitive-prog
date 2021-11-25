package competitive.leetcode.easy.list;

public class ReverseList {
	
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
    
	private ListNode reverseList(ListNode prev, ListNode node) {
		if (node == null) return null;
		ListNode next = node.next;
		node.next = prev;
		return next == null ? node : reverseList(node, next);
	}
	
	public ListNode reverseListRec(ListNode head) {
        return reverseList(null, head);
    }
	
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
    }
	 
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    	System.out.println(new ReverseList().reverseList(l1));
    }
}
