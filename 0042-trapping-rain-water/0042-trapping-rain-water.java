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
    
    public int trap_(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int water = 0;

        prefix[0] = height[0];
        for(int i = 1; i < n; i++){
            prefix[i] = Integer.max(prefix[i-1], height[i]);
        }

        suffix[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i] = Integer.max(suffix[i+1], height[i]);
        }

        for(int i = 0; i < n;i++){
            int min = Integer.min( prefix[i], suffix[i] );
            water += min - height[i];
        }
        return water;
    }
}
