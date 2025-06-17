class Solution(object):
    def isBalanced(self, root):
        def height(node):
            if not node:
                return 0
            
            left_height = height(node.left)
            right_height = height(node.right)

            if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
                return -1

            return 1 + max(left_height, right_height)
    
        return height(root) != -1

        
