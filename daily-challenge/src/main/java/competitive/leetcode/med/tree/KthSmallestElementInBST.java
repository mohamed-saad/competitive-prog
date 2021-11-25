package competitive.leetcode.med.tree;

public class KthSmallestElementInBST {

	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	
	private int weight(TreeNode node) {
		if (node == null) return 0;
		return weight(node.left) + 1 + weight(node.right);
	}
	
    public int kthSmallest(TreeNode root, int k) {
        int smallerNodesCount = weight(root.left) + 1;
        if (smallerNodesCount == k) {
        	return root.val;
        } else if (smallerNodesCount < k) {
        	// search to the right
        	return kthSmallest(root.right, k-smallerNodesCount);
        } else {
        	// search to the left
        	return kthSmallest(root.left, k);
        }
    }
    
    public static void main(String[] args) {
    	TreeNode tree = 
			new TreeNode(200, 
					new TreeNode(100, 
							new TreeNode (50, new TreeNode(25), new TreeNode(75)), 
							new TreeNode (150, new TreeNode(125), new TreeNode(175))
						),
					new TreeNode(300, 
							new TreeNode (250, new TreeNode(225), new TreeNode(275)), 
							new TreeNode (350, new TreeNode(325), new TreeNode(375))
						)
				);
    	System.out.println(new KthSmallestElementInBST().kthSmallest(tree, 1));
    }
}
