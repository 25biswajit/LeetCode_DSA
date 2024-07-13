class Solution {
    int dp[][][] = null;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][2][k+1];
        fill(dp, n, 2, k+1);
        return trade(k, prices, 0, 1); // flag 1 = Buy, 0 = sell
    }

    private int trade(int k, int[] a, int i, int flag){
        int n = a.length;
        if(i >= n || k == 0) return 0;

        if(dp[i][flag][k] != -1) return dp[i][flag][k];

        int noaction = trade(k, a, i+1, flag);
        int action = flag == 1 ? trade(k, a, i+1, 0) - a[i] : trade(k - 1, a, i+1, 1) + a[i];
        int result = Integer.max(noaction, action);
        return dp[i][flag][k] = result;
    }

    private void fill(int[][][] dp, int x, int y, int z){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < z; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
    }
}