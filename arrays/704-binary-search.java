class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { // Use <= to include the last possible value
            int mid = left + (right - left) / 2; // Avoid potential overflow with (left + right) / 2

            if (nums[mid] == target) { // Compare the value at index mid
                return mid; // Return the index of the target
            } else if (nums[mid] < target) { // If the mid value is less than target
                left = mid + 1; // Narrow the search to the right half
            } else { // If the mid value is greater than target
                right = mid - 1; // Narrow the search to the left half
            }
        }
        return -1; // Return -1 if target is not found
    }
}
