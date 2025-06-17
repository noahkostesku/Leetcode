// class Solution {
//     public int[] productExceptSelf(int[] nums) {

//         int[] arr = new int[nums.length];
        
//         for (int i = 0; i <nums.length;i++){
//             int product = 1;
//             for (int j = 0; j < nums.length; j++){
//                 if (j==i){
//                     continue;
//                 }
//                 product *= nums[j];
//             }
//             arr[i] = product;
//         }
//         return arr;
//     }
// }  
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int right = 1, left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        return arr;
    }
}  
