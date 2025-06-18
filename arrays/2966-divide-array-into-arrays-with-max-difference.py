class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        if len(nums) % 3 != 0:
            return []

        result = []
        new_nums = sorted(nums)
        left = 0

        while left < len(new_nums):
            current_arr = new_nums[left:left+3]

            if len(current_arr) != 3 or current_arr[2] - current_arr[0] > k:
                return []

            result.append(current_arr)
            left += 3

        return result
