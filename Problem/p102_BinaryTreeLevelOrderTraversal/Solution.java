// solution1: DFS
package p102_BinaryTreeLevelOrderTraversal;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		traverse(ans, root, 0);
		return ans;
    }
	
	private void traverse(List<List<Integer>> ans, TreeNode curr, int depth) {
		if(curr == null) return;
		
		if(ans.size() <= depth) {	// first node of a level
			ans.add(new ArrayList<Integer>());
		}
		ans.get(depth).add(curr.val);
		
		traverse(ans, curr.left, depth+1);	// travel to left child, and depth plus 1
		traverse(ans, curr.right, depth+1);	// travel to right child, and depth also plus 1
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
