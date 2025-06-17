class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //initial minSum path is 0 starting at node k
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];
            if (visited.contains(n1)) {
                continue;
            }
            //otherwise add the node to the set
            visited.add(n1);
            //accumulate the weight since we have made the connection to the dest node
            t = w1;
            if (edges.containsKey(n1)) {
                for (int[] next : edges.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    //if the set already contains one of the neighbours its been processed already
                    if (!visited.contains(n2)) {
                        //For each neighbour n2 that hasn't been visited, a new entry is added to the priority queue with 
                        minHeap.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }
        //if all nodes are able to be processed the size of the set will be of that of the amount of nodes
        //if all nodes can't be traversed return -1
        return visited.size() == n ? t : -1;
    }
}


