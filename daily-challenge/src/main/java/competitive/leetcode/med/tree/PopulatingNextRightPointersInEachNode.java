package competitive.leetcode.med.tree;

public class PopulatingNextRightPointersInEachNode {

	// Definition for a Node.
	private static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	    
	    @Override
	    public String toString() {
	    	return "(" + val + ")->" + next;
	    }
	};
	
	
	private int hight(Node root) {
		if (root == null) return 0;
		return 1 + hight(root.left);
	}
	
	private Node prev;
	private void visitLevel(Node node, int level) {
		if (level == 0) {
			if (prev != null)
				prev.next = node;
			prev = node;
		} else {
			visitLevel(node.left, level-1);
			visitLevel(node.right, level-1);
		}
	}
	
    public Node connect(Node root) {
         int levels = hight(root);
         for (int i=1; i<levels; i++) {
        	 visitLevel(root, i);
        	 prev = null;
         }
         return root;
    }
	
    public static void main(String[] args) {
    	Node tree = 
			new Node(1, 
					new Node(2, 
							new Node (4, new Node(8), new Node(9)), 
							new Node (5, new Node(10), new Node(11))
						),
					new Node(3, 
							new Node (6, new Node(12), new Node(13)), 
							new Node (7, new Node(14), new Node(15))
						)
				);
    	
    	new PopulatingNextRightPointersInEachNode().connect(tree);
    	System.out.println(tree);
    	System.out.println(tree.left);
    	System.out.println(tree.left.left);
    	System.out.println(tree.left.left.left);

	}
}
