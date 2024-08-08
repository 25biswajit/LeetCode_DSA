class Solution {
    int[][] dp = null;
    public int change(int k, int[] c) {
        int n = c.length;
        dp = new int[n+1][k+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d,-1));
        return ways(c, 0, k);
    }

    int ways(int[] c, int i, int k){
        int n = c.length;
        if(k == 0) return 1;
        if(i >= n) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int take = 0;
        if(k >= c[i]){
            take = ways(c, i, k-c[i]);
        }
        int leave = ways(c, i+1, k);
        return dp[i][k] = take + leave;
    }
}