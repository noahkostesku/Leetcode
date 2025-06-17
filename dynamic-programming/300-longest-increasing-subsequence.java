class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        
        // Initialize LIS array with 1s, as the minimum LIS ending at each element is 1
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
        }

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Check for each element after the current one
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        // Find the maximum value in the LIS array
        int maxLIS = 0;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, LIS[i]);
        }

        return maxLIS;
    }
}


