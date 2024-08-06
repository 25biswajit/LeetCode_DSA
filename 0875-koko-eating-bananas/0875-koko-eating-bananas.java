class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(eatTimes(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
    
    private boolean eatTimes(int[] piles, int k, int h){
        long time=0;
        for(int pile: piles){
            time+=(pile+k-1)/k;
        }
        return time<=h;
    }


    public int minEatingSpeed_(int[] a, int h) {
        long max = Integer.MIN_VALUE;
        for (int j : a) {
            max = Long.max(max, j);
        }
        long low = 1L, high = max, ans = Long.MAX_VALUE;
        while(low <= high){
            long mid = (low + high)/2;
            long time = timeReq(a, mid);
            if(time <= h) {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return (int)ans;
    }

    private long timeReq(int[] a, long t){
        long sum = 0;
        for(int num : a){
            long ans = num / t;
            long rem = num % t;
            if(rem > 0) ans++;
            sum += ans;
        }
        return sum;
    }
}