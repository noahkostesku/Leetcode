from collections import Counter

class Solution(object):
    def isIsomorphic(self, s, t):
        if len(s) != len(t):
            return False

        dict1 = Counter(s)
        dict2 = Counter(t)

        mapping = {}
        for char_s, char_t in zip(s, t):
            if char_s in mapping:
                if mapping[char_s] != char_t:
                    return False
            elif char_t in mapping.values():
                return False
            else:
                mapping[char_s] = char_t

        return True




        
        
