import java.util.HashMap;
import java.util.Map;

class Solution {
    public int repeatedNTimes(int[] nums) {
        // Counter hashmap
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count the occurrences of each number
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Find the element that is repeated n times
        int n = nums.length / 2;  // n is the count of repetition
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }
        
        // In case no element is found, though the problem guarantees that one exists
        return -1;
    }
}
