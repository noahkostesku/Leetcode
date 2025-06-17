class Solution {
    
  public int maxProfit(int[] prices) {
      Map<String, Integer> dp = new HashMap<>();
      return dfs(0, true, prices, dp);
  }

  private int dfs(int i, boolean buying, int[] prices, Map<String, Integer> dp) {
      if (i >= prices.length) {
          return 0;
      }
      String key = i + "," + buying; // Encode 'i' and 'buying' into a String key
      //Without memoization, every time you reach a day in different branches of the decision tree, you would recompute the maximum profit from scratch.
      if (dp.containsKey(key)) {
          return dp.get(key);
      }   
      if (buying) {
          int buy = dfs(i + 1, !buying, prices, dp) - prices[i];
          int cooldown = dfs(i + 1, buying, prices, dp);
          dp.put(key, Math.max(buy, cooldown));
      } else {
        //i+2 on sell since we have to skip a day after selling
          int sell = dfs(i + 2, !buying, prices, dp) + prices[i];
          int cooldown = dfs(i + 1, buying, prices, dp);
          dp.put(key, Math.max(sell, cooldown));
      }
      return dp.get(key);
  }
}


