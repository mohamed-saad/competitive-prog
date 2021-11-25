package competitive.leetcode.easy.tree;

public class ArrayToBST {
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
	
	private TreeNode create(int[] nums, int from, int to) {
		if (from == to) {
			return new TreeNode(nums[from]);
		} else if (from > to) {
			return null;
		}
		int mid = (to+from)/2;
		return new TreeNode(nums[mid], create(nums, from, mid-1), create(nums, mid+1, to));
	}
	
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	return create(nums, 0, nums.length-1);
    }
    
    public static void main(String[] args) {
		new ArrayToBST().sortedArrayToBST(new int[] {-10, -3, 0, 9});
	}
	
}
