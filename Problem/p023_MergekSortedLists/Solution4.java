// merge two list with recursive
package p023_MergekSortedLists;

public class Solution4 {
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		ListNode l1 = null;
		l1 = sol.addNode(l1, 5);
		l1 = sol.addNode(l1, 4);
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
		ListNode l3 = null;
		l3 = sol.addNode(l3, 6);
		l3 = sol.addNode(l3, 2);
		System.out.print("l3:");
		sol.showLinkedList(l3);
		System.out.println("\n-------------");
		ListNode[] lists = {l1, l2, l3};
//		ListNode[] lists = {null};
		ListNode ans = sol.mergeKLists(lists);
		System.out.println("ans:");
		sol.showLinkedList(ans);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        ListNode head = merge(lists, 0, lists.length-1);
        
        return head;
    }
	
	public ListNode merge(ListNode[] lists, int left, int right) {
		if(right == left) return lists[left];
		int mid = left+(right-left)/2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid+1, right);
		return merge2List(l1, l2);
	}
	
	public ListNode merge2List(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val <= l2.val) {
			l1.next = merge2List(l1.next, l2);
			return l1;
		}
		else {
			l2.next = merge2List(l1, l2.next);
			return l2;
		}
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
	
	public class ListNode {
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
