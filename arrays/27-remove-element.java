iclass Solution {
    public int removeElement(int[] nums, int val) {

        int notVal = 0;
        for (int i = 0; i <nums.length; i++){
            if (nums[i] != val){
                nums[notVal] = nums[i];
                notVal++;
            }
        }
        return notVal;

        
    }
}
