package competitive.leetcode.easy.tree;

public class SameTree {

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
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	return 
    		(
    		   (p == null && q == null)
    		|| 
    		   (p != null && q != null) &&
    		   (p.val == q.val) &&
    		   isSameTree(p.left, q.left) && 
    		   isSameTree(p.right, q.right)
    	   );
    }
    
    
    public static void main(String[] args) {
    	TreeNode root1 = new TreeNode(1, new TreeNode(2), null);
    	TreeNode root2 = new TreeNode(1, null, new TreeNode(2));

    	System.out.println(new SameTree().isSameTree(root2, root1));
	}
    
    public static void main2(String[] args) {
		TreeNode root1 = new TreeNode(1);
		{
			TreeNode itr = root1;
			for (int i=0; i<10000; i++) {
				itr.left = new TreeNode(i);
				itr = itr.left;
			}
		}
		TreeNode root2 = new TreeNode(1);
		{
			TreeNode itr = root2;
			for (int i=0; i<10000; i++) {
				itr.right = new TreeNode(i);
				itr = itr.right;
			}
		}

    	System.out.println(new SameTree().isSameTree(root2, root1));
	}
}
