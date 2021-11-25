package competitive.leetcode.easy.list;

public class DeleteNode {
	
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
    public void deleteNode(ListNode node) {
        ListNode itr = node;
        ListNode prev = null;
        while (itr.next != null) {
        	itr.val = itr.next.val;
        	prev = itr;
        	itr = itr.next;
        }
        prev.next = null;
    }
    
}
