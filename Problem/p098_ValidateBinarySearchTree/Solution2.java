package p098_ValidateBinarySearchTree;

public class Solution2 {
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        return bfsBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private boolean bfsBST(TreeNode curr, long left, long right) {	// use long to prevent overflow
		if(curr == null) return true;
		
		long val = curr.val;
		if(val >= left && val <= right) {
			return bfsBST(curr.left, left, val-1) && bfsBST(curr.right, val+1, right);
		}
		return false;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
