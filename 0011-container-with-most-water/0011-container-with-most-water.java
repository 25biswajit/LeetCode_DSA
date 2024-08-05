class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int low = 0, high = n-1, maxArea = 0;

        while(low < high){
            int breath = Integer.min(height[low], height[high]);
            int length = high - low;
            int area = breath * length;
            maxArea = Integer.max( maxArea, area );

            if(height[low] < height[high]){
                low++;
            }else{
                high--;
            }
        }

        return maxArea;
    }
}