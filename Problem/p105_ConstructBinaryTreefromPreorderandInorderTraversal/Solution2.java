package p105_ConstructBinaryTreefromPreorderandInorderTraversal;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] preorder = {1, 2, 3, 4, 5, 6};
		int[] inorder = {5, 4, 3, 2, 1, 6};
		
		TreeNode root = sol.buildTree(preorder, inorder);
		System.out.print("preorder = ");
		sol.preorder(root);
		System.out.println();
		System.out.print("inorder = ");
		sol.inorder(root);
	}
	
	int pre_index = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
        if(len == 1) return new TreeNode(preorder[0], null, null);
        
        return traverse(preorder, inorder, 0, len-1);
    }
	
	private TreeNode traverse(int[] preorder, int[] inorder, int min, int max) {
		if(pre_index >= preorder.length || min > max) return null;
		
		int pre = preorder[pre_index];
		TreeNode node = new TreeNode(pre);
		int i;
		for(i = min; i <= max; i++) {	// I don't use hashmap. Instead, I use for loop to find index
			if(inorder[i] == pre) break;
		}
		pre_index++;
		node.left = traverse(preorder, inorder, min, i-1);
		node.right = traverse(preorder, inorder, i+1, max);
		
		return node;
	}
	
	private void preorder(TreeNode node) {
		if(node == null) {
//			System.out.print("null, ");
			return;
		}
		
		System.out.print(node.val+", ");
		preorder(node.left);
		preorder(node.right);
		return;
	}
	
	private void inorder(TreeNode node) {
		if(node == null) {
//			System.out.print("null, ");
			return;
		}
		
		inorder(node.left);
		System.out.print(node.val+", ");
		inorder(node.right);
		return;
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
