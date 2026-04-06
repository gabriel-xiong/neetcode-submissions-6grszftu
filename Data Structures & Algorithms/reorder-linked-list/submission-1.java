/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next; 

        while (fast != null && fast.next != null)
        {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode second = slow.next; 
        ListNode prev = null; 
        slow.next = null; 

        while(second != null)
        {
            ListNode temp = second.next; 
            second.next = prev; 
            prev = second; 
            second = temp; 
        }

        ListNode start = head; 
        while (prev != null)
        {
            ListNode temp1 = start.next; 
            ListNode temp2 = prev.next; 

            start.next = prev; 
            prev.next = temp1; 

            start = temp1; 
            prev = temp2; 
        }

    }
}
