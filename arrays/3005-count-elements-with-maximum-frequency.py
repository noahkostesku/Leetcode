# from collections import Counter

# class Solution(object):
#     def maxFrequencyElements(self, nums):
        
#         count = Counter(nums)

#         max_num = 0
#         for i, nums in count.items():
#             max_num = max(max_num, nums)

#         total = 0
#         for i, nums in count.items():
#             if count[i] == max_num:
#                 total += max_num
#         return total

class Solution(object):
    def maxFrequencyElements(self, nums):
        
        count_dict = {}

        for i in nums:
            if i in count_dict:
                count_dict[i] += 1
            else:
                count_dict[i] = 1

        max_num = 0
        for i, nums in count_dict.items():
            max_num = max(max_num, nums)

        total = 0
        for i, nums in count_dict.items():
            if count_dict[i] == max_num:
                total += max_num
        return total
        
