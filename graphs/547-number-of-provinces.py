from collections import defaultdict

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        graph = defaultdict(list)

        n = len(isConnected)
        for i in range(n):
            for j in range(n):
                if isConnected[i][j] == 1 and i != j:
                    graph[i].append(j)
                    graph[j].append(i) 

        visited = set()
        result = 0

        def dfs(node: int) -> int:
            visited.add(node)
            for neighbour in graph[node]:
                if neighbour not in visited:
                    dfs(neighbour)

        for node in range(n):
            if node not in visited:
                dfs(node)
                result += 1

        return result
