package p021_MergeTwoSortedLists;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode l1 = null;
		l1 = sol.addNode(l1, 4);
		l1 = sol.addNode(l1, 2);
		l1 = sol.addNode(l1, 1);
		System.out.print("l1:");
		sol.showLinkedList(l1);
		ListNode l2 = null;
		l2 = sol.addNode(l2, 4);
		l2 = sol.addNode(l2, 3);
		l2 = sol.addNode(l2, 1);
		System.out.print("l2:");
		sol.showLinkedList(l2);
		System.out.println("\n-------------");
		ListNode l3 = sol.mergeTwoLists(l1, l2);
		System.out.println("l3:");
		sol.showLinkedList(l3);
		// wa
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) return null;
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		// create an empty node as head of merged linked list, 
		// and a pointer to the rear of merged linked list
		ListNode head = new ListNode(0, null), ptr = head;
		while(l1 != null && l2 != null) {	// if neither l1 and l2 is end
			if(l1.val > l2.val) {	// choose the smaller one into merged linked list
				ListNode node = new ListNode(l2.val, null);
				ptr.next = node;
				ptr = node;
				l2 = l2.next;
			}
			else {
				ListNode node = new ListNode(l1.val, null);
				ptr.next = node;
				ptr = node;
				l1 = l1.next;
			}
		}
		if(l1 == null) {	// link remain l1 or l2
			ptr.next = l2;
		}
		if(l2 == null) {
			ptr.next = l1;
		}
		
		return head.next;	// return first node of merged linked list
	}
	
	public ListNode addNode(ListNode head, int val) {
		ListNode newNode = new ListNode(val, head);
		return newNode;
	}
	
	public void showLinkedList(ListNode head) {
		for(ListNode lead = head; lead != null; lead = lead.next) {
			System.out.print(lead.val+" ");
        }
		System.out.println();
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}