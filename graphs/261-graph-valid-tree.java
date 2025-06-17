

class Solution {
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return edges.length == 0;
        }
        
        if (edges.length != n - 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }

        Set<Integer> visited = new HashSet<>();

        // Start DFS from node 0 (or any node if graph is not guaranteed to be zero-indexed)
        if (!depthFirstSearch(0, -1, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean depthFirstSearch(int node, int previous, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false; // Found a cycle
        }

        visited.add(node);

        for (int neighbor : adjacencyList.get(node)) {
            if (neighbor == previous) {
                continue; // Skip the edge to the parent node
            }

            if (!depthFirstSearch(neighbor, node, visited)) {
                return false; // Cycle detected in recursion
            }
        }

        return true;
    }
}


