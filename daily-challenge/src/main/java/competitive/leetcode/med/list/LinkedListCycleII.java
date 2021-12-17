package competitive.leetcode.med.list;

public class LinkedListCycleII {

	 private static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     
	     @Override
	    public String toString() {
	    	 return "(" + val + ")";  
	    }
	 }

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				slow = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}

		return null;
	}
    
    public static void main(String[] args) {
    	ListNode node5 = new ListNode(5);
    	ListNode node2 = new ListNode(2, new ListNode(3, new ListNode(4, node5)));
    	node5.next = node2;
    	ListNode node1 = new ListNode(1, node2);

//    	ListNode node5 = new ListNode(-4);
//    	ListNode node2 = new ListNode(7, node5);
//    	node5.next = node2;
//    	ListNode node1 = new ListNode(-1, new ListNode(-7, node2));
    	
    	System.out.println(new LinkedListCycleII().detectCycle(node1));
	}
}
