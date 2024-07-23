class Solution {
    public int jump(int[] a) {
        int max = 0, n = a.length, jump = 0;
        int l = 0, r = 0;

        while(r < n-1){
            for(int i = l; i <= r; i++){
                int reach = i + a[i];
                max = Integer.max(max, reach);
            }
            l = r + 1;
            r = max;
            jump++;
        }    
        return jump;
    }
}