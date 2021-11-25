package competitive.leetcode.easy.list;

public class MergeTwoSortedLists {

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
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode itr1 = l1;
    	ListNode itr2 = l2;
    	ListNode itrMerged = null;
    	ListNode headMerged = null;
    	while(itr1 != null && itr2 != null) {
    		if (itr1.val < itr2.val) {
    			if (itrMerged == null)
    				headMerged = itr1;
    			else {
    				itrMerged.next = itr1;
    			}
    			itrMerged = itr1;    				
    			itr1 = itr1.next;
    		} else {
    			if (itrMerged == null)
    				headMerged = itr2;
    			else
    				itrMerged.next = itr2;
    			itrMerged = itr2;
    			itr2 = itr2.next;
    		}
    	}
		if (itr1 != null) {
			if (itrMerged == null) return itr1;
			itrMerged.next = itr1;
		} else if (itr2 != null) {
			if (itrMerged == null) return itr2;
			itrMerged.next = itr2;
		} else if (itrMerged != null) {
			itrMerged.next = null;
		}
        return headMerged;
    }

    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(40, new ListNode(50)))));
    	ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(400, new ListNode(500)))));
    	System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}
