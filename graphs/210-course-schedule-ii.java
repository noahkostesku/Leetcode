
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create a map to store the prerequisites for each course
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }
        //map each course to its prerequisites in an adjacency list
        for (int[] pair : prerequisites) {
            prereq.get(pair[0]).add(pair[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        //traverse the courses and run dfs on them
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, prereq, visit, cycle, output)) {
                return new int[0]; // Return an empty array if a cycle is detected
            }
        }
        //convert the output array-list into an int[] type
        int[] result = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }

        return result;
    }

    private boolean dfs(int crs, Map<Integer, List<Integer>> prereq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(crs)) {
            return false; // Cycle detected
        }
        if (visit.contains(crs)) {
            return true; // Already visited
        }

        cycle.add(crs);
        for (int pre : prereq.get(crs)) {
            if (!dfs(pre, prereq, visit, cycle, output)) {
                return false; // Cycle detected in the recursive call
            }
        }
        //remove the node from the current path
        cycle.remove(crs);
        //check the visit set. If the course is in visit, you skip it because it's already processed.
        visit.add(crs);
        //You then add the course to the cycle set to mark it as being visited in the current path.
        output.add(crs);

        return true;
    }
}



