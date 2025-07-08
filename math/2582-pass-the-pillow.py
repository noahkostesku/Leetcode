class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        path = list(range(1, n)) + list(range(n, 1, -1))
        cycle_len = len(path)
        return path[time % cycle_len]
