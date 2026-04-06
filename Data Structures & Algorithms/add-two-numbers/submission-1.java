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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return convertToLL(calculateNumber(l1) + calculateNumber(l2)); 
    }

    private int calculateNumber(ListNode node)
    {
        if (node == null)
            return 0; 

        int sum = 0;
        int count = 0; 

        while (node !=null)
        {
            sum += Math.pow(10, count) * node.val; 
            node = node.next; 
            count++; 
        }

        return sum; 
    }

    private ListNode convertToLL(int x)
    {
        ListNode head = new ListNode(); 
        ListNode temp = head; 
        if (x == 0)
            return new ListNode(0); 
        while (x > 0)
        {
            temp.next = new ListNode(x%10);
            temp = temp.next; 
            x/=10; 
        }

        return head.next; 
    }
}
