class Solution {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        //the last column will have 1s if t is an empty string (think of matrix)
        for (int i = 0; i <= s.length(); i++) {
            cache[i][t.length()] = 1;
        }
        //the last row + 1 will be all zeros if s is empty
        for (int j = t.length() - 1; j >= 0; j--) {
            cache[s.length()][j] = 0;
        }
        //go through every cell
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    //for both possible cases
                    //they may be another of the same letter after the current one in string s
                    //hence cache[i+!][j] tests for that
                    cache[i][j] = cache[i + 1][j + 1] + cache[i + 1][j];
                } else {
                    cache[i][j] = cache[i + 1][j];
                }
            }
        }
        return cache[0][0];
    }
}


