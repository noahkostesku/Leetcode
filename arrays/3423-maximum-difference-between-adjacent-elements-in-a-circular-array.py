import math

class Solution(object):
    def maxAdjacentDistance(self, nums):
        if len(nums) < 2:
            return 0 

        left = 0
        right = 1

        maximum = float('-inf')
        for i in range(len(nums)):
            maximum = max(maximum, abs(nums[left] - nums[right]))
            left += 1
            right = (right + 1) % len(nums)

        return maximum
        
