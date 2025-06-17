class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
        cache[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                //match is true if the characters s[i] and p[j] match, or if p[j] is . (which matches any character). If i is out of bounds (i.e., i == s.length()), match is false.
                boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
                    cache[i][j] = cache[i][j + 2];
                    if (match) {
                        //if (match) checks if the characters s[i] and p[j] match. If they do, the result also depends on whether s[i+1:] matches p[j:], 
                        //which is represented by cache[i + 1][j].
                        cache[i][j] = cache[i + 1][j] || cache[i][j];
                    }
                } else if (match) {
                    //If p[j+1] is not * but match is true, we check if s[i+1:] matches p[j+1:].
                    cache[i][j] = cache[i + 1][j + 1];
                }
            }
        }

        return cache[0][0];
    }
}


