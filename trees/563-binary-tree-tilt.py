# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.sum_ = 0

    def findTilt(self, root: Optional[TreeNode]) -> int:
        
        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            self.sum_ += abs(left - right)
            return node.val + left + right

        dfs(root)
        return self.sum_

