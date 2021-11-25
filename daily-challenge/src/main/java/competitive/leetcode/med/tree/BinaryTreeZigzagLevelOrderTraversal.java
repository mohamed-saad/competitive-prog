package competitive.leetcode.med.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> zigzag = new LinkedList<>();
    	if (root==null) return zigzag;
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	boolean leftToRight = true;
    	while (!queue.isEmpty()) {
    		int count = queue.size();
    		LinkedList<Integer> level = new LinkedList<>();
    		zigzag.add(level);
    		for (int i=0; i<count; i++) {
    			TreeNode node = queue.remove();
    			if (leftToRight) level.addLast(node.val);
    			else level.addFirst(node.val);
    			if (node.left != null) queue.add(node.left);
    			if (node.right != null) queue.add(node.right);
    		}
    		leftToRight = !leftToRight;
    	}
    	return zigzag;
    }
}
