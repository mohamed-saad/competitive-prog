package competitive.leetcode.easy.tree;

public class SymmetricTree {
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

    private boolean equals(TreeNode first, TreeNode second) {
    	if (first == null || second == null)
    		return first == second;
    	return (first.val == second.val) && equals(first.right, second.left) && equals(first.left, second.right);  
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return equals(root.left, root.right);
    }
}
