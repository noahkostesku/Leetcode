class Solution {
    public int firstUniqChar(String s) {
        // Create a hash map to store the frequency of each character
        Map<Character, Integer> countMap = new HashMap<>();
        
        // First pass: count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // Second pass: find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;  // Return the index of the first non-repeating character
            }
        }
        
        // If no non-repeating character exists, return -1
        return -1;
    }
}
