# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeElements(self, head, val):
        # Handle cases where the head node(s) need to be removed
        while head is not None and head.val == val:
            head = head.next

        curr = head
        prev = None

        while curr is not None:
            if curr.val == val:
                if prev is not None:
                    prev.next = curr.next
                curr = curr.next
            else:
                prev = curr
                curr = curr.next
        
        return head

            

        
