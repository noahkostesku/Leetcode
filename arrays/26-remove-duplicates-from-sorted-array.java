class Solution {
    public int removeDuplicates(int[] nums) {
        
        int uniqueVal = 1;
        for (int i = 1; i < nums.length;i++){
            if (nums[i] != nums[i-1]){
                nums[uniqueVal] = nums[i];
                uniqueVal++;
            }
        }
        return uniqueVal;
    }
}
