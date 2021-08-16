package p105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] preorder = {1, 2, 3, 4, 5, 6};
		int[] inorder = {5, 4, 3, 2, 1, 6};
		
		TreeNode root = sol.buildTree(preorder, inorder);
		System.out.print("preorder = ");
		sol.preorder(root);
		System.out.println();
		System.out.print("inorder = ");
		sol.inorder(root);
	}
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int pre_index = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
        if(len == 1) return new TreeNode(preorder[0], null, null);
        
        for(int i = 0; i < len; i++) {
        	map.put(inorder[i], i);	// hashmap: is (i, index of i in inorder)
        }
        
        return traverse(preorder, 0, len-1);
    }
	
	private TreeNode traverse(int[] preorder, int min, int max) {
		if(pre_index >= preorder.length) return null;	// preorder is done
		
		int pre = preorder[pre_index];
		int in_index = map.get(pre);	// find index in hashmap
		if(in_index >= min && in_index <= max) {
			pre_index++;	// next node
			TreeNode left = traverse(preorder, min, in_index-1);	// search left part
			TreeNode right = traverse(preorder, in_index+1, max);	// search right part
			return new TreeNode(pre, left, right);
		}
		else {	// not found
			return null;
		}
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
