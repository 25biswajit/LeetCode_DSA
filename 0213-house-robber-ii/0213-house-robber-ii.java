class Solution {
    int[] dp = null;
    public int rob(int[] a) {
        int n = a.length;
        if(n == 1) return a[0];
        dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = solve(a,0,n-2,0);
        Arrays.fill(dp,-1);
        return Integer.max(ans, solve(a,1,n-1,1));
    }

    private int solve(int[] a, int s, int e, int i){
        if(i > e) return 0;
        if(dp[i] != -1) return dp[i];

        int noaction = solve(a,s,e,i+1);
        int action = solve(a,s,e,i+2) + a[i];
        int result = Integer.max(noaction, action);
        return dp[i] = result;
    }
}