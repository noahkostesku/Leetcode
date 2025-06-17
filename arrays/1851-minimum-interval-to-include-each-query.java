import java.util.*;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> queryResultMap = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);

        int i = 0;
        for (int query : sortedQueries) {
            // Add all intervals that start before or when the query starts
            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.add(intervals[i]);
                i++;
            }

            // Remove intervals that end before the query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            // Get the smallest interval that covers the query
            if (!minHeap.isEmpty()) {
                int[] smallestInterval = minHeap.peek();
                queryResultMap.put(query, smallestInterval[1] - smallestInterval[0] + 1);
            } else {
                queryResultMap.put(query, -1);
            }
        }

        // Populate the result array based on the original order of queries
        for (int j = 0; j < queries.length; j++) {
            res[j] = queryResultMap.get(queries[j]);
        }

        return res;
    }
}
