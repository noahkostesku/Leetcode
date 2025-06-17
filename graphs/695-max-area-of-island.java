class Solution {
    int current_sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max_sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    current_sum = 0;
                    dfs(grid, i, j);
                    max_sum = Math.max(max_sum, current_sum);
                }
            }
        }
        return max_sum > 0 ? max_sum : 0;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        current_sum++;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}


