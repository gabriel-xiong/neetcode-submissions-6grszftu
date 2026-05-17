# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = head 
        fast = head.next 

        while fast and fast.next: 
            slow = slow.next 
            fast = fast.next.next 

        secondHalf = slow.next 
        slow.next = None # sever first half from second 

        # reverse second half 
        prev = None
        curr = secondHalf 

        while curr: 
            temp = curr.next 
            curr.next = prev 
            prev = curr 
            curr = temp 
        
        # combine prev (6, 5, 4) with head (0, 1, 2, 3) 


        while prev: 
           headTemp = head.next 
           prevTemp = prev.next

           head.next = prev
           prev.next = headTemp
           
           head = headTemp 
           prev = prevTemp 

           