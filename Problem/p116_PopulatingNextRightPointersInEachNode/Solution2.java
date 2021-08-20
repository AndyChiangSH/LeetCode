package p116_PopulatingNextRightPointersInEachNode;

public class Solution2 {
	public static void main(String[] args) {
		
	}
	
	public Node connect(Node root) {
        if(root == null) return null;
        Node head = root;
        
        while(head.left != null) {
        	for(Node ptr = head; ptr != null; ptr = ptr.next) {
        		ptr.left.next = ptr.right;
        		if(ptr.next != null) ptr.right.next = ptr.next.left;
        	}
        	head = head.left;
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
