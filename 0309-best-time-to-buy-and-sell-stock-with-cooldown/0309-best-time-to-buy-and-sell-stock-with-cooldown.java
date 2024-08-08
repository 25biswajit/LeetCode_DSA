class Solution {
    int[][] dp = null;
    public int maxProfit(int[] p) {
        int n = p.length;
        dp = new int[n][2];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d,-1));
        //flag = 0 Buy 1 sell
        return profit(p, 0, 0);
    }

    int profit(int[] p, int i, int flag){
        int n = p.length;
        if(i >= n) return 0;
        if(dp[i][flag]!= -1) return dp[i][flag];
        int action = 0;
        int noAction = profit(p, i+1, flag);
        //buy
        if(flag == 0){
            action = profit(p, i+1, 1) - p[i];
        }
        //sell i.e. 1
        else{
            action = profit(p, i+2, 0) + p[i];
        }
        return dp[i][flag] = Integer.max(noAction, action);
    }
}