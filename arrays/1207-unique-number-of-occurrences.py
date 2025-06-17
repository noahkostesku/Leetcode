# from collections import Counter

# class Solution(object):
#     def uniqueOccurrences(self, arr):
        
#         dict = Counter(arr)
#         visited = set()

#         for _, count in dict.items():
#             if count in visited:
#                 return False
#             visited.add(count)
#         return True
        
#without Counter class

class Solution(object):
    def uniqueOccurrences(self, arr):

        count_dict = {}
        for num in arr:
            if num in count_dict:
                count_dict[num] += 1
            else:
                count_dict[num] = 1
        
        visited = set()
        for count in count_dict.values():
            if count in visited:
                return False
            visited.add(count)
        
        return True
