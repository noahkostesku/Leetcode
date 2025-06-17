class Solution(object):
    def maxPower(self, s):
        
        left, right = 0, 1

        if len(s) == 1:
            return 1

        #sliding window approach
        curr_max = 1
        maximum = 1
        while right < len(s):
            while right < len(s) and s[left] == s[right]:
                curr_max += 1
                right += 1
            
            maximum = maximum if maximum > curr_max else curr_max
            curr_max = 1
            left = right
            right += 1

        return maximum
            
            
            
        
