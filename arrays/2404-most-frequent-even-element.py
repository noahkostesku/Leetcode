from collections import Counter

class Solution(object):
    def mostFrequentEven(self, nums):
        count_dict = Counter(nums)

        maximum = 0
        curr_max = 0

        for i in count_dict:
            if i % 2 == 0:
                curr_max = count_dict[i]
                maximum = max(maximum, curr_max)
        
        arr = []
        for i in count_dict:
            if count_dict[i] == maximum and i % 2 == 0: 
                arr.append(i)

        arr.sort() 
        return arr[0] if len(arr) > 0 else -1




        
