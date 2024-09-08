class Solution {
    public int maxArea(int[] a) {
        int n = a.length;
        int l = 0, r = n-1, area = 0;
        while(l < r){
            int len = r - l;
            int bre = Integer.min(a[l], a[r]);
            area = Integer.max( area, len * bre);
            if(a[l] > a[r]) r--;
            else l++;
        }
        return area;
    }
}