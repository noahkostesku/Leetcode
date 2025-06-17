public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Create the prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
        
        // Create the answer matrix
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine the boundaries of the block
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Sum of the block using prefix sums
                answer[i][j] = prefix[r2 + 1][c2 + 1]
                             - prefix[r1][c2 + 1]
                             - prefix[r2 + 1][c1]
                             + prefix[r1][c1];
            }
        }
        
        return answer;
    }
}
