package p025_ReverseNodesInKGroup;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] nums = {1,2,3,4,5,6,7};
		ListNode head = sol.addNode(null, -1), ptr = head;
		for(int i = 0; i < nums.length; i++) {
			ptr.next = sol.addNode(null, nums[i]);
			ptr = ptr.next;
		}
		sol.showLinkedList(head.next);
		ListNode ans = sol.reverseKGroup(head.next, 7);
		sol.showLinkedList(ans);
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;	// null condition
        if(k < 2) return head;	// don't have to reverse
        
        int len = 0;
        for(ListNode ptr = head; ptr != null; ptr = ptr.next) {	// count length of linked list
        	len++;
        }
        int mul = len/k;	// divide to len/k part
        ListNode newHead = reverse(head, mul, k);	// recursive
        
        return newHead;
    }
	
	private ListNode reverse(ListNode newHead, int mul, int k) {
		if(mul == 0) return newHead;	// last part is smaller than k
		
		// reverse the part from [newHead, newHead+k]
		ListNode pre = null, cur = newHead, nex = newHead.next; 
    	for(int i = 0; i < k; i++) {
    		cur.next = pre;
    		pre = cur;
    		cur = nex;
    		nex = nex == null ? null : nex.next;
    	}
    	newHead.next = reverse(cur, mul-1, k);	// link the last node of this part to the first node in next part
    	
    	return pre;	// return first node of reversed part
	}
	
	public ListNode addNode(ListNode head, int val) {
		ListNode newNode = new ListNode(val, head);
		return newNode;
	}
	
	public void showLinkedList(ListNode head) {
		for(ListNode lead = head; lead != null; lead = lead.next) {
			System.out.print(lead.val+" -> ");
        }
		System.out.println();
	}
	
	public class ListNode {
	    int val;
	    ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
