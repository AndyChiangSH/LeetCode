package p116_PopulatingNextRightPointersInEachNode;

public class Solution {
	public static void main(String[] args) {
		
	}
	
	public Node connect(Node root) {
        if(root == null) return null;
        Node head = root;
        
        while(head.left != null) {	// head is the node on the far left in a level
        	head.left.next = head.right;	// connect left child and right child of head
        	Node last = head.right;		// last node
        	for(Node ptr = head.next; ptr != null; ptr = ptr.next) {	// we view last level as a linked list (KEYPOINT!!)
        		ptr.left.next = ptr.right;	// connect left child and right child
        		last.next = ptr.left;	// connect last node and left child
        		last = ptr.right;	// update last
        	}
        	head = head.left;	// go to next lower level
        }
        
        return root;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
}
