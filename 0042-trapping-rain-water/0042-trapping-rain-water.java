class Solution {
    public int trap(int[] height) {
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