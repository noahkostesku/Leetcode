from collections import defaultdict, deque

class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:

        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = [False] * n
        component_sizes = []

        for node in range(n):
            if not visited[node]:
                size = 0
                queue = deque([node])
                visited[node] = True
                while queue:
                    current = queue.popleft()
                    size += 1
                    for neighbor in adj[current]:
                        if not visited[neighbor]:
                            visited[neighbor] = True
                            queue.append(neighbor)
                component_sizes.append(size)

        total_pairs = n * (n - 1) // 2
        reachable_pairs = sum(size * (size - 1) // 2 for size in component_sizes)
        return total_pairs - reachable_pairs
