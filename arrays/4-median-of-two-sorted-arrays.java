class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int top = 0;
        int bottom = 0;
        int j = 0;
        int[] arr = new int[nums1.length + nums2.length];

        while (top < nums1.length && bottom < nums2.length){

            if (nums1[top] < nums2[bottom]){
                arr[j++] = nums1[top++];
            } else {
                arr[j++] = nums2[bottom++];
            }
        }
        while (top < nums1.length){
            arr[j++] = nums1[top++];
        }
        while (bottom < nums2.length){
            arr[j++] = nums2[bottom++];
        }

        return (arr.length % 2 == 0) 
        ? ((double) arr[arr.length / 2 - 1] + (double) arr[arr.length / 2]) / 2 
        : (double) arr[arr.length / 2];


    }
}
