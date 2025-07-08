# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        
        prev, curr = head, head.next
        pos = 1
        critical_indices = []

        while curr and curr.next:
            next = curr.next
            if (curr.val > prev.val and curr.val > next.val) or (curr.val < prev.val and curr.val < next.val):
                critical_indices.append(pos)

            prev = curr
            curr = next
            pos += 1

        if len(critical_indices) < 2:
            return [-1, -1]

        min_dist = min(b - a for a, b in zip(critical_indices, critical_indices[1:]))
        max_dist = critical_indices[-1] - critical_indices[0]

        return [min_dist, max_dist]
