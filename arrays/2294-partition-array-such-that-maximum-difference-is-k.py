class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:

        nums_sort = sorted(nums)
        left, result = 0, 0

        while left < len(nums_sort):
            right = left
            while right < len(nums_sort) and nums_sort[right] - nums_sort[left] <= k:
                right += 1

            result += 1 
            left = right

        return result

            
