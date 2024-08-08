class Solution {
    int[][] dp = null;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0; 
        dp = new int[n][amount+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
        int result = solve(coins, n, amount, 0);
        return result >= Integer.MAX_VALUE-1 ? -1 : result;
    }

    private int solve(int[] coins, int n, int amount, int i){
        if(amount == 0) return 0;
        if(i >= n) return Integer.MAX_VALUE-1;
        if(dp[i][amount] != -1) return dp[i][amount];

        int take = Integer.MAX_VALUE-1;
        if(coins[i] <= amount){
            take = solve(coins, n, amount - coins[i], i) + 1;
        }
        int leave = solve(coins, n, amount, i+1);
        int result = Integer.min(take, leave); 
        return dp[i][amount] = result;
    }
}