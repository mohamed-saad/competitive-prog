package competitive.leetcode.med.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
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
	
	public void inorderTraversal(TreeNode node, List<Integer> list) {
		if (node == null) return;
		inorderTraversal(node.left, list);
		list.add(node.val);
		inorderTraversal(node.right, list);
    }
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new LinkedList<>();
    	inorderTraversal(root, list);
    	return list;
    }
}
