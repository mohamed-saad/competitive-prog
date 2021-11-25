package competitive.leetcode.med.list;

public class IntersectionOfTwoLinkedLists {
	 private static class ListNode {
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

	 private int length(ListNode n) {
		 ListNode itr = n;
		 int length = 0;
		 while (itr != null) {
			 length++;
			 itr = itr.next;
		 }
		 return length;
	 }
	 
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	 int lengthA = length(headA);
    	 int lengthB = length(headB);
    	 
    	 ListNode itrA = headA;
    	 ListNode itrB = headB;
    	 
    	 while (lengthA > lengthB && itrA != null) {
    		 itrA = itrA.next;
    		 lengthA--;
    	 }
    	 
    	 while (lengthB > lengthA && itrB != null) {
    		 itrB = itrB.next;
    		 lengthB--;
    	 }
    	 
    	 while(itrA != null && itrB != null) {
    		 if (itrA == itrB) return itrA;
    		 itrA = itrA.next;
    		 itrB = itrB.next;
    	 }
    	 return null;
     }
 
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    	ListNode l3 = new ListNode(7, new ListNode(70, new ListNode(700, new ListNode(7000, l1))));
    	ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, l1))));
    	
    	System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(l2, l3));
    }
}
