class Solution {
    public int maxProfit(int[] a) {
        //flag buy = 1, sell 0
        int n = a.length;
        int[][] dp = new int[n][2];
        Arrays.stream(dp).forEach( sa -> Arrays.fill(sa,-1));
        return trade(a, 0, 1, dp);
    }

    private int trade(int[] a, int i, int flag, int[][] dp){
        int n = a.length;
        if(i >= n) return 0;
        if(dp[i][flag] != -1) return dp[i][flag];
        int noaction = trade(a, i+1, flag, dp);
        int action = flag == 1 ? trade(a, i+1, 0, dp)-a[i] : trade(a, i+1, 1, dp)+a[i];
        int result = Integer.max( noaction, action );

        return dp[i][flag] = result;
    }
}