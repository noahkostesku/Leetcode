from typing import List
from collections import deque

class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        rows, cols = len(matrix), len(matrix)
        queue = deque([(0, 0)])
        visited = set()
        
        total_sum = 0
        min_abs = float('inf')
        neg_count = 0

        while queue:
            i, j = queue.popleft()
            if (i, j) in visited:
                continue
            visited.add((i, j))

            val = matrix[i][j]
            total_sum += abs(val)
            if val < 0:
                neg_count += 1
            min_abs = min(min_abs, abs(val))

            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                ni, nj = i + dx, j + dy
                if 0 <= ni < rows and 0 <= nj < cols and (ni, nj) not in visited:
                    queue.append((ni, nj))

        if neg_count % 2 == 0:
            return total_sum
        else:
            return total_sum - 2 * min_abs
