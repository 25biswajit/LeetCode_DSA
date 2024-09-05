class Solution {
    int[] dp = null;
    public int rob(int[] a) {
        int n = a.length;
        if(n == 1) return a[0];
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = money(a, 0, n-2);
        Arrays.fill(dp, -1);
        return Integer.max(ans, money(a, 1, n-1));
    }

    int money(int[] a, int i, int e){
        if(i > e) return 0;
        if(dp[i]!= -1) return dp[i];
        int take = a[i] + money(a, i+2, e);
        int leave = money(a, i+1, e);
        return dp[i] = Integer.max(take, leave);
    }
}