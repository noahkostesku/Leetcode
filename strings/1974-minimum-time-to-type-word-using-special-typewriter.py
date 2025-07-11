class Solution:
    def minTimeToType(self, word: str) -> int:
        
        result = 0
        prev_pos = ord("a")

        for char in word:
            curr_pos = ord(char)
            distance = abs(curr_pos - prev_pos)
            min_distance = min(distance, 26 - distance)
            result += min_distance + 1
            prev_pos = curr_pos


        return result

