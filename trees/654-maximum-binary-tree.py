# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        
        def build(nums: List[int], left: int, right: int) -> Optional[TreeNode]:
            if left > right:
                return None

            max_index = max(enumerate(nums[left:right+1], start=left), key=lambda x: x[1])[0]
            root = TreeNode(nums[max_index])
            root.left = build(nums, left, max_index - 1)
            root.right = build(nums, max_index + 1, right)

            return root

        return build(nums, 0, len(nums) - 1)
