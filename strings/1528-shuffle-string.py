from typing import List

class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        char_array = [''] * len(s)
        result_array = [''] * len(s)
        
        for index, char in enumerate(s):
            char_array[index] = char
            result_array[indices[index]] = char 
        
        result_string = ""
        for char in result_array:
            result_string += char
            
        return result_string
            

        
        
            
