package competitive.leetcode.easy.tree;

public class BalancedBinaryTree {

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
	
	private boolean balanced = true;
	
	private int height(TreeNode node) {
		if (node == null) return 0;
		int right = height(node.right);
		int left = height(node.left);
		if (balanced && Math.abs(left-right) > 1) balanced = false;
		return 1 + Math.max(right, left);
	}
	
    public boolean isBalanced(TreeNode root) {
		height(root);
		return balanced;
    }
    
    public static void main(String[] args) {
		System.out.println(new BalancedBinaryTree().isBalanced(new TreeNode(1, new TreeNode(2), null)));
		System.out.println(new BalancedBinaryTree().isBalanced(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
		System.out.println(new BalancedBinaryTree().isBalanced(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3))));
		System.out.println(new BalancedBinaryTree().isBalanced(new TreeNode(1, new TreeNode(2, null, new TreeNode(4, null, new TreeNode(5))), new TreeNode(3))));
		System.out.println(new BalancedBinaryTree().isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(5)), new TreeNode(4, null, new TreeNode(5))), new TreeNode(2, new TreeNode(4, null, new TreeNode(5)), new TreeNode(4, null, new TreeNode(5))))));
	}
    
}
