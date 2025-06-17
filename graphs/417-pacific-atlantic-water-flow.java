class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        Set<Pair<Integer, Integer>> pac = new HashSet<>();
        Set<Pair<Integer, Integer>> atl = new HashSet<>();

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights, heights[0][c]);
            dfs(ROWS - 1, c, atl, heights, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights, heights[r][0]);
            dfs(r, COLS - 1, atl, heights, heights[r][COLS - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Pair<Integer, Integer> cell = new Pair<>(r, c);
                if (pac.contains(cell) && atl.contains(cell)) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, Set<Pair<Integer, Integer>> visit, int[][] heights, int prevHeight) {
        if (visit.contains(new Pair<>(r, c)) || r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || heights[r][c] < prevHeight) {
            return;
        }
        visit.add(new Pair<>(r, c));
        dfs(r + 1, c, visit, heights, heights[r][c]);
        dfs(r - 1, c, visit, heights, heights[r][c]);
        dfs(r, c + 1, visit, heights, heights[r][c]);
        dfs(r, c - 1, visit, heights, heights[r][c]);
    }
}

