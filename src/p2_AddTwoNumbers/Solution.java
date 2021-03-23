package p2_AddTwoNumbers;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
	
	public class ListNode // linked list node
	{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode l3 = null, cur = null, pre = null;
        int carry = 0;
        // go through the linked list until both linked list is end.
        while(l1 != null || l2 != null) 
        {
            int sum = 0;
            if(l1 == null)  // remain l2
            {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null)  // remain l1
            {
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else	// remain both
            {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = 0;
            
            if(sum>=10)	// If sum more than 10, it carry 1 to next digit.
            {
                carry = 1;
            }
            cur = new ListNode(sum%10, null);	// new node
            if(pre != null) // not first time
            {
                pre.next = cur;	// previous node points to current
            }
            else
            {
                l3 = cur;	// l3 points to header of l3
            }
            pre = cur;            
        }
        if(carry == 1)	// if the least digit is more than 10, it carry 1 to next digit.
        {
            cur = new ListNode(1, null);
            pre.next = cur;
        }
        
        return l3;
    }
}
