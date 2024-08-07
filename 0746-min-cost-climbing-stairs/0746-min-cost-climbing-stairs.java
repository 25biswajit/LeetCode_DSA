class Solution {
    int[] dp = null;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        int step0 = solve(cost, 0, n);
        Arrays.fill(dp , -1);
        int step1 = solve(cost, 1, n);
        return Math.min(step0, step1);
    }

    int solve(int[] cost, int i, int n){
        if(i == n-1 || i == n-2) return cost[i];
        if(dp[i]!=-1) return dp[i];
        int ans = Math.min( solve(cost, i+1, n), solve(cost, i+2, n) ) + cost[i];
        return dp[i] = ans;
    }
}