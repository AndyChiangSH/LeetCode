// solution1: BFS
package p102_BinaryTreeLevelOrderTraversal;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution2 {
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();	// queue to put nodes in same level
		if(root == null) return ans;
		
		queue.add(root);	// add root into queue
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int count = queue.size();
			for(int i = 0; i < count; i++) {
				TreeNode curr = queue.poll();	// dequeue the node in head
				list.add(curr.val);
				if(curr.left != null) queue.add(curr.left);		// if left child is not null, add it into queue
				if(curr.right != null) queue.add(curr.right);	// if right child is not null, add it into queue
			}
			ans.add(list);
		}
		
		return ans;
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
