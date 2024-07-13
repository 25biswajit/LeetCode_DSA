class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sell = prices[n-1];
        int profit = 0;
        for(int i = n-2; i >= 0; i--){
            profit = Integer.max(profit, sell-prices[i]);
            sell = Integer.max(sell, prices[i]);
        }
        return profit;
    }
}