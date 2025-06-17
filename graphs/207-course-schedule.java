class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();

        //Create an empty list for the 2nd part in the hashmap
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        //include the prerequisites for each course in the map
        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        //perform dfs on each course to validate it
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, preMap, visiting)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs, HashMap<Integer, List<Integer>> preMap, Set<Integer> visiting) {
        //if the set already contains the number we are at there's loop so it's invalid
        if (visiting.contains(crs)) {
            return false;
        }
        //if the map is empty it has no prerequisites so you can take it and recursively apply subproblems
        if (preMap.get(crs).isEmpty()) {
            return true;
        }
        //add the course to check its prereqs
        visiting.add(crs);
        //for each prereq check if its valid (no loop)
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre, preMap, visiting)) {
                //if dfs returns false return false
                return false;
            }
        }
        //remove the current node because all prereqs have been explored
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}


