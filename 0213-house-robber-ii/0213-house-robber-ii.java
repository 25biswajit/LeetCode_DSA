class Solution {
    int[] dp = null;
    public int rob(int[] a) {
        int n = a.length;
        if(n==1) return a[0];
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        int ans1 = rob(a, 0, n-1);
        Arrays.fill(dp , -1);
        int ans2 = rob(a, 1, n);
        return Math.max(ans1, ans2);
    }

    int rob(int[] a, int i, int n){
        if(i >= n) return 0;
        if(dp[i]!= -1) return dp[i];
        int take = a[i] + rob(a, i+2, n);
        int leave = rob(a, i+1, n);
        return dp[i] = Math.max(take, leave);
    }
}