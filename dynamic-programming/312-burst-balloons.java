class Solution {
    public int maxCoins(int[] nums) {
        int[][] cache = new int[nums.length + 2][nums.length + 2];
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        for (int offset = 2; offset < newNums.length; offset++) {
            for (int left = 0; left < newNums.length - offset; left++) {
                int right = left + offset;
                for (int pivot = left + 1; pivot < right; pivot++) {
                    int coins = newNums[left] * newNums[pivot] * newNums[right];
                    coins += cache[left][pivot] + cache[pivot][right];
                    cache[left][right] = Math.max(coins, cache[left][right]);
                }
            }
        }
        return cache[0][newNums.length - 1];
    }
}





