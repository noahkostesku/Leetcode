import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Create a frequency map for arr1
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create the result array to hold the sorted elements
        List<Integer> result = new ArrayList<>();

        // Step 3: Place elements of arr1 that are in arr2
        for (int num : arr2) {
            if (frequencyMap.containsKey(num)) {
                int count = frequencyMap.get(num);
                for (int i = 0; i < count; i++) {
                    result.add(num);
                }
                // Remove the element from the frequency map
                frequencyMap.remove(num);
            }
        }

        // Step 4: For the remaining elements (not in arr2), sort them and add to result
        List<Integer> remaining = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(remaining); // Sort in ascending order
        
        for (int num : remaining) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
        }

        // Step 5: Convert result list back to an array
        int[] sortedArr1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            sortedArr1[i] = result.get(i);
        }

        return sortedArr1;
    }
}
