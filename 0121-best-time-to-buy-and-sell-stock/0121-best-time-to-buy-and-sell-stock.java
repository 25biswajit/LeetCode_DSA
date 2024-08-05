class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sellMax = prices[n-1];
        int profit = 0;

        for(int i = n-2; i >= 0; i--){
            profit = Integer.max(profit, sellMax - prices[i]);
            sellMax = Integer.max(sellMax, prices[i]);
        }
        
        return profit;
    }
}