class Solution {
    public int maxProfit(int[] a) {
        int n = a.length;
        int profit = 0;
        int sell = a[n-1];

        for(int i = n-2; i >= 0; i--){
            profit = Integer.max(profit, sell-a[i]);
            sell = Integer.max(sell, a[i]);
        }

        return profit;
        
    }
}