class Solution {
    int[][] dp = null;
    public int maxProfit(int[] arr) {
        int n = arr.length;
        dp = new int[n][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        return profit(arr, n, 0, 0); //buy 0 sell 1
    }
 
    int profit(int[] a, int n, int i, int f){
        if(i >= n) return 0;
        if(dp[i][f] != -1) return dp[i][f];
        int action = 0;
        int noaction = profit(a, n, i+1, f);
        if(f == 1){ // sell
            action = profit(a, n, i+1, 0) + a[i];
        }else{ // buy
            action = profit(a, n, i+1, 1) - a[i];
        }
        return dp[i][f] = Integer.max(noaction, action);
    }
}