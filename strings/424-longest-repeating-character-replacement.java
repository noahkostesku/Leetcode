class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int ans = 0;
        int max = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            max = Math.max(max, map.get(currentChar));

            //j-i+1 represents size of sliding window
            if (j - i + 1 - max > k) {
                char startChar = s.charAt(i);
                map.put(startChar, map.get(startChar) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
