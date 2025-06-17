

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create frequency maps for s1 and s2
        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();
        
        // Populate the frequency map for s1
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        // Initial population of the frequency map for s2
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
        }

        // Compare initial window
        if (s1Count.equals(s2Count)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {
            char startChar = s2.charAt(i - s1.length());
            char endChar = s2.charAt(i);

            // Remove the character going out of the window
            s2Count.put(startChar, s2Count.get(startChar) - 1);
            if (s2Count.get(startChar) == 0) {
                s2Count.remove(startChar);
            }

            // Add the character coming into the window
            s2Count.put(endChar, s2Count.getOrDefault(endChar, 0) + 1);

            // Compare maps
            if (s1Count.equals(s2Count)) {
                return true;
            }
        }

        return false;
    }
}
