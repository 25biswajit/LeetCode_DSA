class Solution {
    public int jump(int[] a) {
        int left = 0, right = 0, maxReach = 0, n = a.length, jump = 0;

        while(right < n-1){
            for(int i = left; i <= right; i++){
                maxReach = Integer.max(maxReach, a[i] + i);
            }
            left = right + 1;
            right = maxReach;
            jump++;
        }
        return jump;
    }
}