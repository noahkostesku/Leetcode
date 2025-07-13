# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        nodes = []

        def revInorder(node: TreeNode) -> None:
            if not node:
                return None

            revInorder(node.right)
            nodes.append(node)
            revInorder(node.left)

        revInorder(root)

        running_sum = 0

        for node in nodes:
            running_sum += node.val
            node.val = running_sum

        return root
