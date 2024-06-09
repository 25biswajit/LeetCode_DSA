class Solution {
    public int maxProfit(int p, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][p+1][2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < p+1; j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = -1;
                }
            }   
        }

        return maxProfit(p, 0, n, 0, prices, dp);
    }

    int maxProfit(int k, int i, int n, int flag, int[] a, int[][][] dp) {
        if (i == n || k == 0) return 0;
        if (dp[i][k][flag] != -1) return dp[i][k][flag];
        int noAction = 0, take = 0;
        if (flag == 0) {// buy
            take = -a[i] + maxProfit(k, i + 1, n, 1, a, dp);
        } 
        else if (flag == 1) {// sell
            take = a[i] + maxProfit(k - 1, i + 1, n, 0, a, dp);
        }
        noAction = maxProfit(k, i + 1, n, flag, a, dp);
        return dp[i][k][flag] = Integer.max(noAction, take);
    }
}
