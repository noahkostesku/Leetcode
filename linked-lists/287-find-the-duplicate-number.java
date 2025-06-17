class Solution {
    public int findDuplicate(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //iterate through each entry using entrySet()
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            //entry.getValue() to get value
            if (entry.getValue() > 1){
                //entry.getKey() to get corresponding key
                return entry.getKey();
            }
        }
        return 0;
    }
}

