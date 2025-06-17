class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        // Check if the current subtree is the same as subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Helper method to check if two trees are the same
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}


