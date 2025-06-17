class Solution(object):
    def removeOccurrences(self, s, part):
        s = list(s)

        while True:
            found = False  
            #valid slicing range
            for i in range(len(s) - len(part) + 1):
                if s[i:i+len(part)] == list(part):  
                    del s[i:i+len(part)]  
                    found = True
                    break  
            if not found:
                break

        return "".join(s)


        
