class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxDist = 0;
        //LIP matrix for memoization
        int[][] memo = new int[rows][cols];

        //list of possible directions to go in from current cell
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                //update max dist for every distance found for every cell
                maxDist = Math.max(maxDist, dfs(matrix, i, j, memo, dirs));
            }
        }
        return maxDist;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo, int[][] dirs) {
        //a zero represents an unvisited node --> memoization to prevent redundancy
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int res = 1;
        //iterates through every possible neighbour of the current cell
        //x-coord --> row, y-coord --> col
        for (int[] dir : dirs) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            //check bounds and to see if neighbour is increasing 
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[r][c]) {
                //the "1+" accounts for the current cell itself as its technically a path = 1
                //recursively call neighbours if valid
                res = Math.max(res, 1 + dfs(matrix, newRow, newCol, memo, dirs));
            }
        }
        memo[r][c] = res;
        return res;
    }
}



