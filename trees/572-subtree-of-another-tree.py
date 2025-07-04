# Definition for first_tree binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None:
            return False

        if self.isSameTree(root, subRoot):
            return True

        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def isSameTree(self, first_tree: Optional[TreeNode], second_tree: Optional[TreeNode]) -> bool:
        if not first_tree and not second_tree:
            return True
        if not first_tree or not second_tree:
            return False
        if first_tree.val != second_tree.val:
            return False
        return self.isSameTree(first_tree.left, second_tree.left) and self.isSameTree(first_tree.right, second_tree.right)



        if root.val == subRoot.val:
            return root.left.val == subRoot.left.val and root.right.val == subRoot.right.val

        return False
