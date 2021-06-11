package p019_RemoveNthNodeFromEndOfList;

import p019_RemoveNthNodeFromEndOfList.Solution3.ListNode;

public class Solution4 {
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		ListNode head = null;
		head = sol.addNode(head, 1);
		sol.showLinkedList(head);
		System.out.println("\n-------------");
		sol.removeNthFromEnd(head, 1);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ls = new ListNode();
		ls.next = head;
		ListNode f = ls;
		ListNode s = ls;
		for(int i = 0; i < n; i++) {
			f = f.next;
		}
		while(f.next != null) {
			f = f.next;
			s = s.next;
		}
		s.next = s.next.next;
		return ls.next;
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
