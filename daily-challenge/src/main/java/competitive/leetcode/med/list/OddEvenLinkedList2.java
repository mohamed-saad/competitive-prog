package competitive.leetcode.med.list;

public class OddEvenLinkedList2 {
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
	
     public ListNode oddEvenList(ListNode head) {
    	 if (head == null) return head;
     
    	 ListNode itrOdd = head;
    	 ListNode itrEven = head.next;
    	 ListNode firstEven = head.next;
    	 
    	 while(itrEven != null && itrEven.next != null) {
    		 itrOdd.next = itrEven.next;
    		 itrOdd = itrOdd.next;
    		 itrEven.next = itrOdd.next;
    		 itrEven = itrEven.next;
    	 }

    	 itrOdd.next = firstEven;
    	 return head;
     }
     
     public static void main(String[] args) {
     	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
     	System.out.println(new OddEvenLinkedList2().oddEvenList(l1));
     }
}
