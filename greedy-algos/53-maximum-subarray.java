class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int curr_sum = 0;
        int max = nums[0];

        for (int n : nums) {
            if (curr_sum < 0) {
                curr_sum = 0;
            }
            curr_sum += n;
            max = Math.max(max, curr_sum);
        }
        return max;
    }
}


