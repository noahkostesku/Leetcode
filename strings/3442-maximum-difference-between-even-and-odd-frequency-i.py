from collections import Counter

class Solution:
    def maxDifference(self, s: str) -> int:
        counter = Counter(s)
        odd_freqs = []
        even_freqs = []

        for freq in counter.values():
            if freq % 2 == 0:
                even_freqs.append(freq)
            else:
                odd_freqs.append(freq)

        if not odd_freqs or not even_freqs:
            return -1

        max_diff = float('-inf')
        for odd in odd_freqs:
            for even in even_freqs:
                max_diff = max(max_diff, odd - even)

        return max_diff



        

