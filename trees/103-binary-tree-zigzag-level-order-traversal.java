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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root ==null) return new ArrayList<>();
        
        List<List<Integer>> list= new ArrayList<>();

        Queue<TreeNode> q= new LinkedList<>();

        q.offer(root);

        // We toggle this variable from true to false & vice versa
        boolean isReversed=true;

        while(!q.isEmpty()){
            int size= q.size();
            ArrayList<Integer> innerList= new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode current= q.poll();
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
                innerList.add(current.val);                
            }
            // This helps us to reverse the list alternatively
            if(!isReversed){
                Collections.reverse(innerList);
            }

            list.add(innerList);

            // This is to toggle the isReversed variable
            isReversed= !isReversed;

        }
        return list;
    }
    
}
