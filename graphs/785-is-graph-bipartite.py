class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        nodes = set(i for i in range(len(graph))) | set(neighbor for neighbors in graph for neighbor in neighbors)
        num_nodes = len(nodes)
        colour = [-1] * num_nodes

        def dfs(node: int, current_colour: int) -> bool:
            colour[node] = current_colour
            for neighbour in graph[node]:
                if colour[neighbour] == -1:
                    # 1- current_colour alternates colours
                    if not dfs(neighbour, 1 - current_colour):
                        return False
                elif colour[neighbour] == current_colour:
                    return False  
            return True

        '''
        if only connected was required then it's simply:
        
        return dfs(0, 0)

        '''

        # required for disconnected graphs
        for node in range(num_nodes):
            if colour[node] == -1:
                if not dfs(node, 0):
                    return False

        return True
