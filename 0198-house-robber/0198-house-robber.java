class Solution {
    int[] dp = null;
    public int rob(int[] a) {
        int n = a.length;
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        return rob(a, 0, n);
    }

    int rob(int[] a, int i, int n){
        if(i >= n) return 0;
        if(dp[i]!= -1) return dp[i];
        int take = a[i] + rob(a, i+2, n);
        int leave = rob(a, i+1, n);
        return dp[i] = Math.max(take, leave);
    }
}