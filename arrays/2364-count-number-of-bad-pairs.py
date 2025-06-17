class Solution(object):
    def countBadPairs(self, nums):

        freq = {}
        good_pair = 0
        n = len(nums)

        for i in range(n):
            key = i - nums[i]  
            #.get(key, 0) to initialize empty count to 0, prevent access before being initialized
            good_pair += freq.get(key, 0) 
            freq[key] = freq.get(key, 0) + 1  

        #bad = total - good
        total_pairs = (n * (n - 1)) // 2
        return total_pairs - good_pair

        
