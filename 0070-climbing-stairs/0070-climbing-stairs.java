class Solution {
    int[] dp = null;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    int solve(int i) {
        if(i <= 2) return i;
        if(dp[i]!=-1) return dp[i];
        else dp[i] = solve(i-1) + solve(i-2);
        return dp[i];
    }
}