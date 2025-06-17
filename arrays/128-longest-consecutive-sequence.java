class Solution {
    public int longestConsecutive(int[] nums) {


        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int length = 1;
                while (numSet.contains(n + length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;

        


    }
}
