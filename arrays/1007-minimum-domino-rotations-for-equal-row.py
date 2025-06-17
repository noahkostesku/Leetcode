from collections import Counter
from typing import List

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        tops_sort = sorted(tops)
        bots_sort = sorted(bottoms)
        tops_dict = Counter(tops_sort)
        bot_dict = Counter(bots_sort)
        
        sorted_dict_top = sorted(tops_dict.items(), key=lambda x: x[1], reverse=True)
        sorted_dict_bot = sorted(bot_dict.items(), key=lambda x: x[1], reverse=True)

        top_ptr = 0
        bot_ptr = 0
        n = len(tops)

        while top_ptr < len(sorted_dict_top):
            candidate = sorted_dict_top[top_ptr][0] 
            top_rot = 0
            bot_rot = 0
            valid = True

            for i in range(n):
                if tops[i] != candidate and bottoms[i] != candidate:
                    valid = False
                    break
                elif tops[i] != candidate:
                    top_rot += 1
                elif bottoms[i] != candidate:
                    bot_rot += 1

            if valid:
                return min(top_rot, bot_rot)

            top_ptr += 1

        while bot_ptr < len(sorted_dict_bot):
            candidate = sorted_dict_bot[bot_ptr][0]
            top_rot = 0
            bot_rot = 0
            valid = True

            for i in range(n):
                if tops[i] != candidate and bottoms[i] != candidate:
                    valid = False
                    break
                elif tops[i] != candidate:
                    top_rot += 1
                elif bottoms[i] != candidate:
                    bot_rot += 1

            if valid:
                return min(top_rot, bot_rot)

            bot_ptr += 1

        return -1
