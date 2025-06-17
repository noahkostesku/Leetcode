import java.util.HashMap;
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int zeros = 0;
        // Count zeros
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }
        
        // Iterate from the end and shift elements
        for (int i = n - 1; i >= 0; i--) {
            if (i + zeros < n) {
                map.put(i + zeros, arr[i]);
            }
            
            if (arr[i] == 0) {
                zeros--;
                if (i + zeros < n) {
                    map.put(i + zeros, 0);
                }
            }
        }
        
        // Update the array with values from the map
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) {
                arr[i] = map.get(i);
            }
        }
    }
}


