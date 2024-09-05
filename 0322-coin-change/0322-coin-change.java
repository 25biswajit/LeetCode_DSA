class Solution {
    int[][] dp = null;
    public int coinChange(int[] c, int k) {
        int n = c.length;
        dp = new int[n+1][k+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d,-1));
        int ans = coin(c, 0, k);
        return ans >= Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    int coin(int[] c, int i, int k){
        int n = c.length;
        if(k == 0) return 0;
        if(i >= n) return Integer.MAX_VALUE-1;
        if(dp[i][k] != -1) return dp[i][k];
        int take = Integer.MAX_VALUE-1;
        if(k >= c[i]){
            take = 1 + coin(c, i, k - c[i]);
        }
        int leave = coin(c, i+1, k);
        return dp[i][k] = Integer.min(take, leave);
    }
}