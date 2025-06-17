class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int peakIndex = -1;

        //check left boundary and left neighbour
        //check right boundary and right neighbour
        //combos:
        //1. no left neighbour + right neightbour
        //2. no right neighbour + left neighbour
        //3. both left neighbour and right neighbour
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                peakIndex = i;
                break; 
            }
        }

        return peakIndex;
    }
}
