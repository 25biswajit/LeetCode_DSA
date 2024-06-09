class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return maxProfit(k, 0, n, 0, prices, dp);
    }

    int maxProfit(int k, int i, int n, int flag, int[] a, int[][] dp){
        if(i >= n || k == 0) return 0;
        if(dp[i][flag] != -1) return dp[i][flag];
        int noAction = 0, take = 0;
        if(flag == 0){//buy
            take = - a[i] + maxProfit(k, i+1, n, 1, a, dp);
        }
        else if(flag == 1){//sell
            take = a[i] + maxProfit(k-1, i+1, n, 0, a, dp);
        }
        noAction = maxProfit(k, i+1, n, flag, a, dp);
        return dp[i][flag] = Integer.max(noAction, take);
    }
}