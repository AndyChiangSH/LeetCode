package p019_RemoveNthNodeFromEndOfList;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = null;
		head = sol.addNode(head, 1);
		sol.showLinkedList(head);
		System.out.println("\n-------------");
		sol.removeNthFromEnd(head, 1);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n == 1)) return null;
        
        int i = 0;
        ListNode lead, follow;
        for(lead = head, follow = null; lead != null; lead = lead.next, i++) {
        	if(i == n) {
        		follow = head;
        	}
        	else if(i > n) {
        		follow = follow.next;
        	}
        }
        if(follow == null) {
        	head = head.next;
        }
        else {
        	follow.next = follow.next.next;
        }
        
        return head;
    }
	
	public ListNode addNode(ListNode head, int val) {
		ListNode newNode = new ListNode(val, head);
		return newNode;
	}
	
	public void showLinkedList(ListNode head) {
		for(ListNode lead = head; lead != null; lead = lead.next) {
			System.out.print(lead.val+" ");
        }
	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
