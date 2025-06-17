class Solution(object):
    def repeatedCharacter(self, s):

        visited = set()

        for i in s:
            if i in visited:
                return i
            visited.add(i)
        
        
