class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            low = Integer.min(low, bloomDay[i]);
            high = Integer.max(high, bloomDay[i]);
        }

        int mid = 0, ans = Integer.MAX_VALUE;
        boolean isPossible = false;
        while(low <= high){
            mid = (low + high)/2;
            isPossible = minDays(bloomDay, mid, m, k);
            if(isPossible){
                ans = Integer.min(ans, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    boolean minDays(int[] a, int d, int m, int k){
        int n = a.length;
        int i = 0, bouquets = 0, k_ = k;
        while(i < n){
            if(a[i] <= d && k > 0){
                k--;
                if(k == 0){
                    k = k_;
                    bouquets++;
                }
            }
            else if(a[i] > d){
                k = k_;
            }
            i++;
        }

        return (bouquets >= m);
    }

    
}