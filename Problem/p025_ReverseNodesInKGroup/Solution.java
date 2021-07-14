package p025_ReverseNodesInKGroup;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
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
        if(head == null) return null;
        if(k < 2) return head;
        int len = 0;
        for(ListNode ptr = head; ptr != null; ptr = ptr.next) {
        	len++;
        }
        int mul = len/k;
        ListNode newHead = reverse(head, mul, k);
//        showLinkedList(newHead);
        
        return newHead;
    }
	
	private ListNode reverse(ListNode newHead, int mul, int k) {
//		System.out.println("mul = "+mul);
		
		if(mul == 0) return newHead;
		
		ListNode pre = null, cur = newHead, nex = newHead.next; 
    	for(int i = 0; i < k; i++) {
    		
//    		System.out.println("cur = "+cur.val);
    		
    		cur.next = pre;
    		pre = cur;
    		cur = nex;
    		nex = nex == null ? null : nex.next;
    	}
//    	System.out.println("pre = "+pre.val+", cur = "+cur.val+", nex = "+nex.val+", newHead = "+newHead.val);
//    	showLinkedList(pre);
    	newHead.next = reverse(cur, mul-1, k);
    	
    	return pre;
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
