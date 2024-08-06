class Solution {
    public int minEatingSpeed(int[] a, int h) {
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