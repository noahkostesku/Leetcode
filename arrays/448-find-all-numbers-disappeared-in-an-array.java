class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Mark each number's position as negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Calculate the index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark the number at this index as negative
            }
        }
        
        // Find positions that were never marked (i.e., numbers that are missing)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // If the number is positive, the number (i + 1) is missing
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
