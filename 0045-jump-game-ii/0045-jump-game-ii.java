class Solution {
    public int jump(int[] a) {
        int n = a.length;
        int i = 0, maxreach = 0, reach = 0, jump = 0;
        while(i < n-1){
            reach = Integer.max( reach , a[i] + i);
            if(i == maxreach){
                maxreach = reach;
                jump++;
                if(maxreach > n) return jump;
            }
            i++;
        }
        return jump;
    }
}