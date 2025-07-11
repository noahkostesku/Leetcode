class Solution:
    def smallestNumber(self, pattern: str) -> str:
        stack = []  
        result = ""  
        
        for i in range(len(pattern) + 1):  
            stack.append(str(i + 1))  

            # pop stack on "I"
            if i == len(pattern) or pattern[i] == "I":  
                while stack:
                    result += stack.pop()
                    
        return result


