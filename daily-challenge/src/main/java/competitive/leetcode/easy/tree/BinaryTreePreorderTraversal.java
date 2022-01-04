package competitive.leetcode.easy.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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
	
	private void preorderTraversal(TreeNode root, List<Integer> order) {
		if (root == null) return;
		order.add(root.val);
		preorderTraversal(root.left, order);
		preorderTraversal(root.right, order);
	}
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> order = new LinkedList<>();
    	preorderTraversal(root, order);
    	return order;
    }
    
}
