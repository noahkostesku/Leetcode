class Solution:
    def possibleStringCount(self, word: str) -> int:
        left, total = 0, 0

        for right in range(1, len(word) + 1):
            if right == len(word) or word[right] != word[left]:
                running_length = right - left
                if running_length > 1:
                    total += (running_length - 1)
                left = right

        return total + 1 # to count occurence where all chars occur once

        
