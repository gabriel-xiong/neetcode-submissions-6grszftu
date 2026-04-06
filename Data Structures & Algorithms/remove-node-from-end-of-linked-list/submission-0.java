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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head; 
        if (temp == null)
            return temp; 
        
        int count = 0; 
        while (temp!= null)
        {   count++; 
            temp = temp.next; 
        }

        temp = head; 
        int realIndex = count - n; 
        if (realIndex == 0)
            return temp.next; 
        
        int curr = 0;
        for (int i = 0; i < realIndex - 1; i++ )
        {
            temp = temp.next; 
        }

        temp.next = temp.next.next; 

        return head; 
    }
}
