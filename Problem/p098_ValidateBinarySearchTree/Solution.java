package p098_ValidateBinarySearchTree;

public class Solution {
	public boolean isValidBST(TreeNode root) {
        return bfsBST(root, null, null);	// null consider as max integer and min integer
    }
	
	private boolean bfsBST(TreeNode curr, Integer left, Integer right) {
		if(curr == null) return true;
		
		int val = curr.val;
		if((left == null || val > left) && (right == null || val < right)) {
			return bfsBST(curr.left, left, val) && bfsBST(curr.right, val, right);
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
