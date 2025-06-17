/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //guarantedd a result so can create an infinite loop 
        while (true){
            //if both p and q > root search right half
            if (p.val > root.val && q.val > root.val){
                root = root.right;
            //if both p and q < root LCA is on the elft side
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                //does a split occur?
                return root;
            }
        }




        
    }
}

