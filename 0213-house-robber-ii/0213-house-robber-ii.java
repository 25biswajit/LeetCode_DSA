class Solution {
    public int rob(int[] a) {
        int n = a.length;
        if(n == 1) return a[0];
        int dp[] = new  int[n];
        Arrays.fill(dp, -1);
        int ans1 = rob(0, n-2, a, dp);
        Arrays.fill(dp, -1);
        int ans2 = rob(1, n-1, a, dp);
        return Integer.max ( ans1 , ans2 );
    }

    private int rob(int i, int n, int[] a, int[] dp){
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int noAction = rob(i+1, n, a, dp);
        int take = a[i] + rob(i+2, n, a, dp);
        return dp[i] = Integer.max(noAction, take);
    }

    
}