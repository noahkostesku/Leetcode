// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// class Solution {
//     //iterative inorder traversal
//     public int kthSmallest(TreeNode root, int k) {
//         //go to the left most node and keep track until reach null
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;

//         while (!stack.isEmpty() || curr != null) {
//             while (curr != null) {
//                 //have to go back to cur after processing cur.left so add to stack to go back to it
//                 stack.push(curr);
//                 curr = curr.left;
//             }
//             //we are at null so pop and decrease k because we got to the minimum value so far, not the kth minimum value
//             curr = stack.pop();
//             k--;
//             //once k = 0 we got to the kth value
//             if (k == 0) {
//                 return curr.val;
//             }
//             //go through the right subtree
//             curr = curr.right;
//         }

//         return -1;

//     }
// }

class Solution {
    private int count = 0;  // Counter to keep track of nodes visited
    private int result = -1;  // Variable to store the k-th smallest element

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;  // Found the k-th smallest element
            return;
        }

        inOrderTraversal(node.right, k);
    }
}


