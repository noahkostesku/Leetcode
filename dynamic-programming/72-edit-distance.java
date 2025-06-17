class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int j = 0; j <= word2.length(); j++) {
            //an empty word1 can add chars to word2
            dp[word1.length()][j] = word2.length() - j;
        }
        for (int i = 0; i <= word1.length(); i++) {
            //an empty word2 can make word 1 delete its elements to get there
            dp[i][word2.length()] = word1.length() - i;
        }
        //check every cell
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    //matching is not an operation so add 1
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    //requires an operation so choose the minimum of the three
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        //solution will be in the top left due to bottom-up dp
        return dp[0][0];
    }
}


