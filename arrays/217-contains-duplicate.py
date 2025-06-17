# from collections import Counter

# class Solution(object):
#     def containsDuplicate(self, nums):
#         dupls = Counter(nums)  
#         for num in dupls:
#             if dupls[num] > 1:
#                 return True
        
#         return False

class Solution(object):
    def containsDuplicate(self, nums):
        nums.sort()

        i = 0
        while (i+1 < len(nums)):
            if nums[i] == nums[i+1]:
                return True
            i+=1
        return False
        
