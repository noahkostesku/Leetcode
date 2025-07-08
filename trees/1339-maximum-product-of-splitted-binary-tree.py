class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        MOD = 10**9 + 7
        subtree_sums = []

        def get_total_sum(node):
            if not node:
                return 0
            return node.val + get_total_sum(node.left) + get_total_sum(node.right)

        total = get_total_sum(root)

        def dfs(node):
            if not node:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            current_sum = node.val + left + right
            product = current_sum * (total - current_sum)
            subtree_sums.append(product)
            return current_sum

        dfs(root)
        return max(subtree_sums) % MOD
