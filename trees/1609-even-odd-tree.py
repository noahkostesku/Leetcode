# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        queue = [root]
        sign = 1
        # if we didn't know if the tree started with even or odd then we could simply do sign = root.val % 2

        while queue:
            prev_val = None

            for _ in range(len(queue)):
                node = queue.pop(0)

                if node.val % 2 != sign:
                    return False

                if prev_val is not None:
                    if sign == 1 and node.val <= prev_val:
                        return False
                    if sign == 0 and node.val >= prev_val:
                        return False

                prev_val = node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            sign = 1 - sign

        return True
