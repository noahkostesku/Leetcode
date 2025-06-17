class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(0, 0, nums, target, dp);
    }

    private int backtrack(int i, int total, int[] nums, int target, Map<String, Integer> dp) {
        //if a combination is accumulated to the target add 1 to the amount of possible combinations else return 0
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        String key = i + "," + total; // Use a composite key of "i,total"
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        //two choices one to add and to subtract so add recursively add both ways
        int ways = backtrack(i + 1, total + nums[i], nums, target, dp)
                + backtrack(i + 1, total - nums[i], nums, target, dp);
        // reuse this result if the same state is encountered again.
        dp.put(key, ways);
        return ways;
    }
}


