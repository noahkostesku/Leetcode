class Solution(object):
    def maxAscendingSum(self, nums):
         #have to check if i + 1 is greater than i, if yes, add it to the current total

        max_ = 0
        for i in range(len(nums)):
            curr_sum = nums[i]
            while i+1 < len(nums):
                if nums[i+1] > nums[i]:
                    curr_sum = curr_sum + nums[i+1]
                    i += 1
                else:
                    break
            max_ = max(max_, curr_sum)
            i += 1

        return max_

            


            
        
