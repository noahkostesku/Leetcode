import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // Step 1: Create a sorted copy of the heights array (this will be the expected order)
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        
        // Step 2: Count how many indices differ between heights and expected arrays
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Step 3: Return the number of indices that are different
        return count;
    }
}
