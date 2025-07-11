from collections import defaultdict

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:


        # build adj list
        graph = defaultdict(list)

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = set()

        def dfs(node):

            if node == destination:
                return True
            
            if node in visited:
                return False

            visited.add(node)

            for neighbour in graph[node]:
                if dfs(neighbour):
                    return True
            return False


        return dfs(source)
