class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int maxFrequency = Integer.MIN_VALUE; // To keep track of the maximum frequency
        int numberWithMaxFrequency = -1;

        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            // Update maxFrequency and numberWithMaxFrequency if current frequency is higher
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                numberWithMaxFrequency = number;
            }
        }

        return numberWithMaxFrequency;
    }
}
