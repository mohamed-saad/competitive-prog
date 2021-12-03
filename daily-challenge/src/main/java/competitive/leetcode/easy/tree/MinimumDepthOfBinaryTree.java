package competitive.leetcode.easy.tree;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
    private int findMinDepth(TreeNode node) {
    	if (node == null) return Integer.MAX_VALUE;
    	if (node.left == null && node.right == null) return 1;
    	return 1 + Math.min(findMinDepth(node.right), findMinDepth(node.left));
    }
    
    public int minDepthSlow(TreeNode root) {
    	if (root == null) return 0;
    	return findMinDepth(root);
    }

    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	int level = 0;
    	while (!queue.isEmpty()) {
    		level++;
    		int count = queue.size();
    		for (int i=0; i<count; i++) {
    			TreeNode node = queue.remove();
    			if (node.left == null && node.right == null) return level;
    			if (node.left != null) queue.add(node.left);
    			if (node.right != null) queue.add(node.right);
    		}
    	}
    	return level;	// we should not reach here
    }

    public static void main(String[] args) {
		System.out.println(new MinimumDepthOfBinaryTree().minDepth(new TreeNode(1, new TreeNode(2), null)));
		System.out.println(new MinimumDepthOfBinaryTree().minDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
		System.out.println(new MinimumDepthOfBinaryTree().minDepth(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3))));
		System.out.println(new MinimumDepthOfBinaryTree().minDepth(new TreeNode(1, new TreeNode(2, null, new TreeNode(4, null, new TreeNode(5))), new TreeNode(3))));
		System.out.println(new MinimumDepthOfBinaryTree().minDepth(new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(5)), new TreeNode(4, null, new TreeNode(5))), new TreeNode(2, new TreeNode(4, null, new TreeNode(5)), new TreeNode(4, null, new TreeNode(5))))));
	}
    
}
