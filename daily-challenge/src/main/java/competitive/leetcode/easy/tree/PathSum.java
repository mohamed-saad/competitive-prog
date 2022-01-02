package competitive.leetcode.easy.tree;

public class PathSum {

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
	
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.right == null && root.left == null){ // leaf
        	return (root.val == targetSum);
        }
        int remains = targetSum - root.val;
        return root.left != null && hasPathSum(root.left, remains) || 
        	   root.right != null && hasPathSum(root.right, remains);
    }
}
