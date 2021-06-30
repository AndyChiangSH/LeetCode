package p023_MergekSortedLists;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
//		ListNode l1 = null;
//		l1 = sol.addNode(l1, 5);
//		l1 = sol.addNode(l1, 4);
//		l1 = sol.addNode(l1, 1);
//		System.out.print("l1:");
//		sol.showLinkedList(l1);
//		ListNode l2 = null;
//		l2 = sol.addNode(l2, 4);
//		l2 = sol.addNode(l2, 3);
//		l2 = sol.addNode(l2, 1);
//		System.out.print("l2:");
//		sol.showLinkedList(l2);
//		System.out.println("\n-------------");
//		ListNode l3 = null;
//		l3 = sol.addNode(l3, 6);
//		l3 = sol.addNode(l3, 2);
//		System.out.print("l3:");
//		sol.showLinkedList(l3);
//		System.out.println("\n-------------");
//		ListNode[] lists = {l1, l2, l3};
		ListNode[] lists = {null};
		ListNode ans = sol.mergeKLists(lists);
		System.out.println("ans:");
		sol.showLinkedList(ans);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int len = lists.length;
        ListNode head = new ListNode(0, null), ptr = head;
        
        while(true) {
        	int notNullNum = 0, notNullIndex = 0, min = Integer.MAX_VALUE, minIndex = 0;
        	for(int i = 0; i < len; i++) {
        		if(lists[i] != null) {
        			if(lists[i].val < min) {
        				min = lists[i].val;
        				minIndex = i;
        			}
        			notNullNum++;
        			notNullIndex = i;
        		}
        	}
    		if(notNullNum == 1) {
    			ptr.next = lists[notNullIndex];
    			break;
    		}
    		else if(notNullNum == 0) {
    			break;
    		}
        	ptr.next = lists[minIndex];
    		ptr = ptr.next;
    		lists[minIndex] = lists[minIndex].next;
        }
        
        return head.next;
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
