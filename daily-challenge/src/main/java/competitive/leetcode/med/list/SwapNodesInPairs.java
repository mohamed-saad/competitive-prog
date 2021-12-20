package competitive.leetcode.med.list;

public class SwapNodesInPairs {
	
	 private static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     
	     @Override
	    public String toString() {
	    	 return "(" + val + ")" + (next == null ? "" : "->" + next);  
	    }
	 }

    public ListNode swapPairs(ListNode head) {
    	ListNode newHead = head;
    	ListNode prev = null;
    	ListNode first = head;
    	
    	while(first != null) {
    		ListNode second = first.next;
    		if (second == null) break;
    		
    		// swap
    		first.next = second.next;
    		second.next = first;
    		if (prev == null) newHead = second;
    		else prev.next = second;
    		
    		// advance
    		prev = first;
    		first = first.next;
    	}
    	
        return newHead;
    }
    
    public static void main(String[] args) {
		System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
		System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
		System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1)));
		System.out.println(new SwapNodesInPairs().swapPairs(null));

    }
}
