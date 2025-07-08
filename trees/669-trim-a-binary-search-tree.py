class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:

        def dfs(node):
            if not node:
                return None

            if node.val < low:
                return dfs(node.right)

            if node.val > high:
                return dfs(node.left)

            node.left = dfs(node.left)
            node.right = dfs(node.right)
            return node

        return dfs(root)
