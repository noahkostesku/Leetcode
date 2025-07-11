class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BSTBuilder(nums, 0, nums.length);
    }


    public TreeNode BSTBuilder(int[] nums, int start, int end){

        if (start >= end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BSTBuilder(nums, start, mid);
        root.right = BSTBuilder(nums, mid + 1, end);

        return root;

    }
}
