class Solution {
    int[] dp = null;
    public int rob(int[] a) {
        int n = a.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(a, n, 0);

    }

    private int solve(int[] a, int n, int i){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        int noaction = solve(a, n, i+1);
        int action = solve(a, n, i+2) + a[i];
        int result = Integer.max(noaction, action);

        return dp[i] = result;
    }
}