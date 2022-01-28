package competitive.leetcode.easy.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

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
	
	private List<Integer> postorder = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
    	if (root != null) {
    		postorderTraversal(root.left);
    		postorderTraversal(root.right);
    		postorder.add(root.val);
    	}
    	return postorder;
    }
}
