package competitive.leetcode.easy.list;

public class RemoveDuplicatesFromSortedList {

	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	      @Override
	      public String toString() {
	    	return "(" + val + ")->" + next;
	      }
	  }

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;

		ListNode itr = head;
		while (itr.next != null) {
			if (itr.val == itr.next.val) {
				itr.next = itr.next.next;
			} else {
				itr = itr.next;
			}
		}
		
 		return head;
	}
	
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))))))));
	}
}
