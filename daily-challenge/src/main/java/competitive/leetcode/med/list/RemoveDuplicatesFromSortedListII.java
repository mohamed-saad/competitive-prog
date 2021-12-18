package competitive.leetcode.med.list;

public class RemoveDuplicatesFromSortedListII {

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

    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) return head;
    	ListNode prev = null;
    	ListNode itr = head;
    	boolean markForDeletion = false;
    	while(itr.next != null) {
    		if (itr.val == itr.next.val) {
    			itr.next = itr.next.next;	// drop next node
    			markForDeletion = true;
    		} else {
    			if (markForDeletion) {
    				// delete node
    				if (prev == null) {
    					head = head.next;
    				} else {
    					prev.next = itr.next;	
    				}
    				markForDeletion = false;
    			} else {
    				prev = itr;
    			}
    			itr = itr.next;
    		}
    	}
    	if (markForDeletion) {
    		if (prev == null) return null;
    		prev.next = null;
    		return head;
    	}
    	return head;
    }
    
    private static ListNode buildList(int... values) {
    	ListNode head = new ListNode(values[0]);
    	ListNode itr = head;
    	for (int i=1; i<values.length; i++) {
    		itr.next = new ListNode(values[i]);
    		itr = itr.next;
    	}
    	return head;
    }
    
    public static void main(String[] args) {
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,1,2,3)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,1,2,3,4,5,6)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,2,3,4,5,6)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,2,3,3,4,5,6)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,2,3,3,4,5,5,5,6)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,2,2,2,2,3,3,4,5,5,5,6)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,2,2,2,2,3,3,4,5,5,5,6,6,6)));
    	System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(buildList(1,1,2,2,2,2,3,3,4,5,5,5,6,6,6)));

	}
    
}
