# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        current = dummy
        node = head.next 
        total = 0

        while node:
            if node.val != 0:
                total += node.val
            else:
                current.next = ListNode(total)
                current = current.next
                total = 0
            node = node.next

        return dummy.next
