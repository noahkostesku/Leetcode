class Solution(object):
    def convertToTitle(self, columnNumber):

        dict_ = {i: chr(i + 64) for i in range(1, 27)}

        result = columnNumber
        final = ""
        while result > 0:  
            result -= 1  
            final = dict_[(result % 26) + 1] + final 
            result //= 26

        return final








        
