class Solution(object):
    def longestMonotonicSubarray(self, nums):

        #increasing
        l1, r1 = 0, 1
        curr, max_ = 1, 1
        while r1 < len(nums):
            if nums[r1] > nums[r1 - 1]: 
                curr += 1
            else:
                curr = 1 
            max_ = max(max_, curr)
            r1 += 1

        #decreasing 
        l2, r2 = 0, 1
        curr2, max_2 = 1, 1
        while r2 < len(nums):
            if nums[r2] < nums[r2 - 1]: 
                curr2 += 1
            else:
                curr2 = 1
            max_2 = max(max_2, curr2)
            r2 += 1

        return max(max_, max_2)


        
