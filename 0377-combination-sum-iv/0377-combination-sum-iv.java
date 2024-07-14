class Solution {
    int[][] dp = null;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n+1][target+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
        return sum(nums, target, 0);
    }

    private int sum(int[] a, int k, int i){
        int n = a.length;
        if(k == 0) return 1;
        if(i >= n) return 0;
        if(dp[i][k] != -1) return dp[i][k];

        int leave = sum(a, k, i+1);
        int take = 0;
        if(a[i] <= k){
            take = sum(a, k - a[i], 0);
        }  
        int result = leave + take;
        return dp[i][k] = result;

    }
}