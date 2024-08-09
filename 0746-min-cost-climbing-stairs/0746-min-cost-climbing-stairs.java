class Solution {
    int[] dp = null;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        int step0 = solve(cost, n-1);
        Arrays.fill(dp , -1);
        int step1 = solve(cost, n-2);
        return Math.min(step0, step1);
    }

    int solve(int[] cost, int i){
        if(i == 0 || i == 1) return cost[i];
        if(dp[i]!=-1) return dp[i];
        int ans = Math.min( solve(cost, i-1), solve(cost, i-2) ) + cost[i];
        return dp[i] = ans;
    }
}