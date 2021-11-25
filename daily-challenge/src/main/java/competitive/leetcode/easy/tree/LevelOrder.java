package competitive.leetcode.easy.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
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
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<>();
    	if (root == null) return result;
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		int levelCount = queue.size();
    		List<Integer> level = new LinkedList<>();
    		result.add(level);
    		for (int i=0; i<levelCount; i++) {
    			TreeNode node = queue.remove();
    			level.add(node.val);
    			if (node.left != null) queue.add(node.left);
    			if (node.right != null) queue.add(node.right);
    		}
    	}
    	return result;
    }
	
    public List<List<Integer>> levelOrder2(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<>();
    	if (root == null) return result;
    	List<Integer> level = new LinkedList<>();
    	result.add(level);
    	Deque<TreeNode> queue = new LinkedList<>();
    	Deque<Integer> levelsQueue = new LinkedList<>();
    	queue.add(root);
    	levelsQueue.add(1);
    	Integer lastAddedLevel = 1;
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.remove();
    		Integer nodeLevel = levelsQueue.remove();
    		if (lastAddedLevel != nodeLevel) {
    			level = new LinkedList<>();
    	    	result.add(level);
    		}
    		lastAddedLevel = nodeLevel;
    		level.add(node.val);
    		if (node.left != null) {
    			queue.add(node.left);
    			levelsQueue.add(nodeLevel + 1);
    		}
    		if (node.right != null) {
    			queue.add(node.right);
    			levelsQueue.add(nodeLevel + 1);
    		}
    	}
        return result;
    }
}
