// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         // If the lengths don't add up, s3 cannot be an interleaving of s1 and s2
//         if (s1.length() + s2.length() != s3.length()) {
//             return false;
//         }
//         // Start the recursive process
//         return isInterleaveRecursive(s1, s2, s3, 0, 0, 0);
//     }

//     private boolean isInterleaveRecursive(String s1, String s2, String s3, int i, int j, int k) {
//         // Base case: if we have reached the end of all strings, return true
//         if (k == s3.length()) {
//             return true;
//         }
//         // Case 1: If the current character of s1 matches the current character of s3, 
//         // and the rest of s3 can be formed by interleaving the rest of s1 and s2
//         if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
//             if (isInterleaveRecursive(s1, s2, s3, i + 1, j, k + 1)) {
//                 return true;
//             }
//         }
//         // Case 2: If the current character of s2 matches the current character of s3,
//         // and the rest of s3 can be formed by interleaving the rest of s1 and s2
//         if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
//             if (isInterleaveRecursive(s1, s2, s3, i, j + 1, k + 1)) {
//                 return true;
//             }
//         }
//         // If neither of the above conditions are met, return false
//         return false;
//     }
// }

//Dynamic Programming Approach

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //diaganol out of bounds is true
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                //same logic as recursive approach
                //if i is in bounds 
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}



