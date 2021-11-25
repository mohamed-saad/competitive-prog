package competitive.leetcode.med.list;

import competitive.leetcode.easy.list.MergeTwoSortedLists;

public class AddTwoNumbers {
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
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode itr1 = l1;
		 ListNode itr2 = l2;
		 ListNode sum = null;
		 ListNode itrSum = null;
		 int carry = 0;
		 while(itr1 != null && itr2 != null) {
			 int s = itr1.val + itr2.val + carry;
			 carry = s/10;
			 ListNode v = new ListNode(s%10);
			 if (sum == null) {
				 sum = v;
			 } else {
				 itrSum.next = v;
			 }
			 itrSum = v;
			 itr1 = itr1.next;
			 itr2 = itr2.next;
		 }
		 ListNode remains = itr1 != null ? itr1 : itr2; 
		 while (remains != null) {
			 int s = remains.val + carry;
			 carry = s/10;
			 ListNode v = new ListNode(s%10);
			 itrSum.next = v;
			 remains = remains.next;
			 itrSum = v;
		 }
		 if (carry != 0)
			 itrSum.next = new ListNode(carry);
		 return sum;
	 }

    public static void main(String[] args) {
//    	ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//    	ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    	ListNode l1 = new ListNode(0);
    	ListNode l2 = new ListNode(0);
    	System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
