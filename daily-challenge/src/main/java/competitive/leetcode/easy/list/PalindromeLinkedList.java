package competitive.leetcode.easy.list;

public class PalindromeLinkedList {

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
	
	private ListNode[] reverse(ListNode prev, ListNode curr, int count) {
		if (count == 0) return new ListNode[] { prev, curr };
		ListNode next = curr.next;
		curr.next = prev;
		return reverse(curr, next, count-1);
	}
	
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode itr = head;
        while(itr != null) {
        	itr = itr.next;
        	count++;
        }
        if (count == 1) return true;
        
        ListNode[] splits = reverse(null, head, count/2);
        if (count%2 == 1) splits[1] = splits[1].next;
        
        ListNode itr1 = splits[0];
        ListNode itr2 = splits[1];
        
        while(itr1 != null) {
        	if (itr1.val != itr2.val) return false;
        	itr1 = itr1.next;
        	itr2 = itr2.next;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    	ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
    	ListNode l3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
    	ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(7, new ListNode(1)))));
    	ListNode l5 = new ListNode(1, new ListNode(2, new ListNode(3)));

//    	ListNode[] splits = new PalindromeLinkedList().reverse(null, l1, 3);
//    	System.out.println(splits[0]);
//    	System.out.println(splits[1]);
    	System.out.println( new PalindromeLinkedList().isPalindrome(l5));
	}
}
