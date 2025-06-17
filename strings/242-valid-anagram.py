from collections import Counter

class Solution(object):
    def isAnagram(self, s, t):
        
        first = Counter(s)
        second = Counter(t)
        return first == second
        
