class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        
        for (int i = 0; i < length; i += 2 * k) {
            // Reverse the first k characters in the current segment
            int end = Math.min(i + k, length); // Ensure we don't go past the end of the string
            String toReverse = s.substring(i, end);
            result.append(new StringBuilder(toReverse).reverse());
            
            // Append the next k characters as they are
            int startNextSegment = end;
            end = Math.min(i + 2 * k, length);
            if (startNextSegment < end) {
                result.append(s.substring(startNextSegment, end));
            }
        }
        
        return result.toString();
    }
}
