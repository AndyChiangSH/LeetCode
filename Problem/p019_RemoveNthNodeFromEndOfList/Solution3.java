package p019_RemoveNthNodeFromEndOfList;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		ListNode head = null;
		head = sol.addNode(head, 1);
		sol.showLinkedList(head);
		System.out.println("\n-------------");
		sol.removeNthFromEnd(head, 1);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        byte i;	// because size is smaller than 30, so byte is enough
        ListNode lead, follow;	// two pointer, lead is leading of linked list, follow is behind the follow by n node
        for(lead = head, follow = null, i = 0; lead != null; lead = lead.next, i++) {
        	if(i == n) {	// if i equals to n, let follow points to head
        		follow = head;
        	}
        	else if(i > n) {	// if i larger than n, move forward one step
        		follow = follow.next;
        	}
        }
        if(follow == null) {	// if follow is null, it means remove head node
        	head = head.next;
        }
        else {	// otherwise, remove follow+1 node
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
