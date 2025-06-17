class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // Initialize all elements with amount + 1
        dp[0] = 0;

        for (int curr_amount = 1; curr_amount <= amount; curr_amount++) {
            for (int c : coins) {
                if (curr_amount - c >= 0) {
                    dp[curr_amount] = Math.min(dp[curr_amount], 1 + dp[curr_amount - c]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}



