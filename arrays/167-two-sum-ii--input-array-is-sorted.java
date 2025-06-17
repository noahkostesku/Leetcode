class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // for (int i =0; i< numbers.length; i++){
        //     for (int j =1; j< numbers.length; j++){
        //         if (numbers[i] + numbers[j] == target){
        //             return new int[]{i+1,j+1};
        //         }
        //     }
        // }
        // return new int[0];

        //two pointers one to the end one at the start
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int currentSum = numbers[left]+numbers[right];

            if (currentSum > target){
                right--;
            } else if (currentSum < target){
                left++;
            } else {
                return new int[]{left+1,right+1};
            }
        }
        return new int[0];
    }

    

}
