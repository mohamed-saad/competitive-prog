package competitive.leetcode.med.tree;

public class ConstructBinaryTreePreorderInorderTraversal {
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
	
	int preOrderIndex;
    private TreeNode buildTree(int[] preorder, int[] inorder, int inOrderFrom, int inOrderTo) {
    	TreeNode node = new TreeNode(preorder[preOrderIndex]);
    	int inorderIndex = inOrderFrom;
    	while (inorder[inorderIndex] != preorder[preOrderIndex]) {
    		inorderIndex++;
    	}
    	if (inorderIndex>inOrderFrom) {
    		preOrderIndex++;
    		node.left = buildTree(preorder, inorder, inOrderFrom, inorderIndex-1);
    	}
    	if (inorderIndex<inOrderTo) {
    		preOrderIndex++;
    		node.right = buildTree(preorder, inorder, inorderIndex+1, inOrderTo);
    	}
    	return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    
    public static void main(String[] args) {
    	TreeNode result = new ConstructBinaryTreePreorderInorderTraversal().buildTree(new int[] {3,20,15,7}, new int[] {3,15,20,7});
    	System.out.println(result);
	}
}
