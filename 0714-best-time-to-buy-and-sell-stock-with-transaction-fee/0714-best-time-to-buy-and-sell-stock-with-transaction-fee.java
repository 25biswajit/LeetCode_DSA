class Solution {
    int[][] dp = null;
    public int maxProfit(int[] arr, int fee) {
        int n = arr.length;
        dp = new int[n][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        return profit(arr, n, 0, 0, fee); //buy 0 sell 1
    }
 
    int profit(int[] a, int n, int i, int f, int fee){
        if(i >= n) return 0;
        if(dp[i][f] != -1) return dp[i][f];
        int action = 0;
        int noaction = profit(a, n, i+1, f, fee);
        if(f == 1){ // sell
            action = profit(a, n, i+1, 0, fee) + a[i] - fee;
        }else{ // buy
            action = profit(a, n, i+1, 1, fee) - a[i];
        }
        return dp[i][f] = Integer.max(noaction, action);
    }
}