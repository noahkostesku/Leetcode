class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        left, right, maximum = 0, 1, -1
        
        while right < len(nums):
            if nums[right] > nums[left]:
                maximum = max(maximum, nums[right] - nums[left])
            else:
                left = right 
            right += 1

        return maximum

        
