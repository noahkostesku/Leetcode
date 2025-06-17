class Solution(object):
    def reverseString(self, s):
        
        # left, right = 0, len(s) - 1

        # while left < right:
        #     s[left], s[right] = s[right], s[left]
        #     left += 1
        #     right -= 1

        # return s

        # without s[:] creates a new list
        s[:] = s[::-1]


        
