class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int result = coinChange(0, coins, amount, n, dp);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }

    private int coinChange(int i, int a[], int k, int n, int dp[][]){
        if(k == 0) return 0;
        if(i >= n || k < 0) return Integer.MAX_VALUE-1;
        if(dp[i][k]!=-1) return dp[i][k];
        int take = Integer.MAX_VALUE;
        int noAction = coinChange(i+1, a, k, n, dp);
        if(k >= a[i]){
            take = 1 + coinChange(i, a, k-a[i], n, dp);
        }
        return dp[i][k] = Integer.min(take, noAction);
    }
}