from collections import defaultdict

class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        edge_counts = defaultdict(int)

        for row in wall:
            position = 0
            for brick in row[:-1]:
                position += brick
                edge_counts[position] += 1

        max_edges = max(edge_counts.values(), default=0)
