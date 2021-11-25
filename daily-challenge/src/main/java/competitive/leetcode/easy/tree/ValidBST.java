package competitive.leetcode.easy.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ValidBST {
	
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
	
	private void inOrder(TreeNode node, List<Integer> order) {
		if (node == null) return;
		inOrder(node.left, order);
		order.add(node.val);
		inOrder(node.right, order);
	}
	
    public boolean isValidBST(TreeNode node) {
    	List<Integer> order = new LinkedList<>();
    	inOrder(node, order);
    	Iterator<Integer> itr = order.iterator();
    	Integer prev = itr.next();
    	while(itr.hasNext()) {
    		Integer current = itr.next();
    		if (prev >= current) return false;
    		prev = current;
    	}
    	return true;
    }
}
