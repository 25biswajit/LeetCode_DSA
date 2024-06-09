class Solution {
    public int coinChange(int[] coins, int amount) {
        return minCoinReqInfinite(coins, amount);
    }

    int dp[][] = null;
    public int minCoinReqInfinite(int[] array, int sum){
        dp = new int[array.length][sum+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,Integer.MAX_VALUE));
        int result = minCoinReqInfinite(array.length-1, sum, array);
        return result == Integer.MAX_VALUE-1 ? -1 : result;
    }

    private int minCoinReqInfinite(int i, int k, int[] array){
        if(k == 0) return 0;
        if(i < 0) return Integer.MAX_VALUE-1;
        if(dp[i][k] == Integer.MAX_VALUE){
            // leave
            dp[i][k] = minCoinReqInfinite(i-1,k,array);
            if(k >= array[i]){
                // pick
                dp[i][k] = Math.min ( dp[i][k] , minCoinReqInfinite(i,k-array[i],array) + 1);
            }
        }
        return dp[i][k];
    }
}