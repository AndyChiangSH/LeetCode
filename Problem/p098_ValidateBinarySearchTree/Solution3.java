package p098_ValidateBinarySearchTree;

public class Solution3 {
	public boolean isValidBST(TreeNode root) {
		return help(root, null, null);
	}
	
	private boolean help(TreeNode curr, Integer left, Integer right) {
	    if(curr == null) return true;
	    return (left == null || curr.val > left) && (right == null || curr.val < right) && help(curr.left, left, curr.val) && help(curr.right, curr.val, right);
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
