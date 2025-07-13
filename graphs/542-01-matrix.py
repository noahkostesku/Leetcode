from collections import deque

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        distance = [[-1] * cols for _ in range(rows)]
        queue = deque()

        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    distance[i][j] = 0
                    queue.append((i, j))

        while queue:
            i, j = queue.popleft()

            for dx, dy in [(0,1), (0,-1), (1,0), (-1,0)]:
                new_i, new_j = i + dx, j + dy

                if 0 <= new_i < rows and 0 <= new_j < cols:
                    if distance[new_i][new_j] == -1:
                        distance[new_i][new_j] = distance[i][j] + 1
                        queue.append((new_i, new_j))

        return distance
