class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> str = new ArrayList<>();
        int n = nums.length;
        int left = 0;

        while (left < n) {
            int right = left;
            while (right + 1 < n && nums[right + 1] == nums[right] + 1) {
                right++;
            }
            if (right > left) {
                str.add(nums[left] + "->" + nums[right]);
            } else {
                str.add(String.valueOf(nums[left]));
            }
            left = right + 1;
        }

        return str;
    }

}
