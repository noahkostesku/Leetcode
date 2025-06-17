# from collections import Counter

# class Solution(object):
#     def sumOfUnique(self, nums):

#         count_dict = Counter(nums)

#         unique_sums = 0
#         for i, _ in count_dict.items():
#             if count_dict[i] == 1:
#                 unique_sums += i
#         return unique_sums


class Solution(object):
    def sumOfUnique(self, nums):

        count_dict = {}
        
        for i in nums:
            if i in count_dict:
                count_dict[i] += 1
            else:
                count_dict[i] = 1

        unique_sums = 0
        for i, _ in count_dict.items():
            if count_dict[i] == 1:
                unique_sums += i
        return unique_sums
        
        
