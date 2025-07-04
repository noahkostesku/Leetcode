"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        clone_graph = {}

        def dfs(original_node: Node) -> Node:

            if original_node in clone_graph:
                return clone_graph[original_node] #return the copy already cloned

            copy_node = Node(original_node.val)
            clone_graph[original_node] = copy_node

            for neighbour in original_node.neighbors:
                copy_node.neighbors.append(dfs(neighbour))

            return copy_node

        return dfs(node)
        
        

