
class Solution {
    public int countComponents(int n, int[][] edges) {
        // Initialize adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Populate adjacency list with edges
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        int count = 0; // Counter for connected components

        // Iterate over all nodes and perform DFS from each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                // Start a new DFS which will mark all nodes in the same component
                dfs(i, adjList, visited);
                count++; // Increment the component count
            }
        }

        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(node);

        // Visit all the neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}


