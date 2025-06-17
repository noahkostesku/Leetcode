class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // Create a set of all numbers in the array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Find the first missing positive integer
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }
}
