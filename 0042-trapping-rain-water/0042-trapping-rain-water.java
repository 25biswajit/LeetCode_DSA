class Solution {
    public int trap(int[] a) {
        int ans = 0;
        int n = a.length;
        int[] lMax = new int[n];
        lMax[0] = a[0];
        for(int i = 1; i < n; i++){
            lMax[i] = Integer.max(lMax[i-1], a[i]);
        }
        int rMax = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--){
            rMax = Integer.max(rMax, a[i]);
            ans += Integer.min(lMax[i], rMax)-a[i];
        }
        return ans;
    }
}