class Solution {
    int[][] dp = null;
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        dp = new int[m+1][n+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
        return path(grid, m, n, 0, 0);
    }

    public int path(int[][] grid, int m, int n, int i, int j){
        if(i==m-1 && j==n-1) return 1;
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int result = path(grid, m, n, i+1, j) + path(grid, m, n, i, j+1);
        return dp[i][j] = result;
    }
}