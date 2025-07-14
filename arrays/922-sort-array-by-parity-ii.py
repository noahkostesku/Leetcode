class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:

        even_arr, odd_arr = [], []
        
        for num in nums:
            if num % 2 == 0:
                even_arr.append(num)
            else:
                odd_arr.append(num)

        result_arr = []
        even_idx, odd_idx = 0, 0

        for i in range(len(nums)):
            if i % 2 == 0:
                result_arr.append(even_arr[even_idx])
                even_idx += 1
            else:
                result_arr.append(odd_arr[odd_idx])
                odd_idx += 1

        return result_arr
