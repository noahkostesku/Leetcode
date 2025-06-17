class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int result_length = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length palindromes
            int left = i;
            int right = i;
            // while left, right are in bound, and left and right are equal for valid palindrome
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // right-left+1 is length
                if (right - left + 1 > result_length) {
                    result = s.substring(left, right + 1);
                    result_length = right - left + 1;
                }
                left--;
                right++;
            }

            // even length palindromes
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > result_length) {
                    result = s.substring(left, right + 1);
                    result_length = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return result;
    }
}
