class Solution {
    public int uniquePaths(int m, int n) {
        //bottom row has all 1s
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            //initialize all rows with 1s
            Arrays.fill(newRow, 1);
            for (int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        //start position
        return row[0];
    }
}


