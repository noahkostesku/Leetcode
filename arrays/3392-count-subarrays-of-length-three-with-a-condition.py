class Solution(object):
    def countSubarrays(self, nums):

        left, right, res = 0, 2, 0

        while right < len(nums):
            mid = left + 1
            if nums[left] + nums[right] == nums[mid] / 2.0:
                res += 1
            left += 1
            right += 1

        return res


        
