# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        copy = head 
        count = 0 
        while copy: 
            count += 1
            copy = copy.next 
        
        if count <= 1: 
            return None 
        
        first = head
        second = head 

        # 1 2 3 4, n = 2 
        index = count - n 
        if index == 0: 
            return head.next
        
        for i in range(index -1): 
            first = first.next 
        
        for i in range(index + 1): 
            second = second.next 

        first.next = second 

        return head
        
