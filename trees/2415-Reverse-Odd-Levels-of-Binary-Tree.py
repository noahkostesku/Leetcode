# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        def dfs(node1: TreeNode, node2: TreeNode, level: int):
            if not node1 or not node2:
                return
            if level % 2 == 1:
                node1.val, node2.val = node2.val, node1.val
            dfs(node1.left, node2.right, level + 1)
            dfs(node1.right, node2.left, level + 1)
        
        if not root:
            return None
        
        dfs(root.left, root.right, 1)
        return root
