class Solution {
    public int jump(int[] a) {
        int max = 0, windowlast = 0, n = a.length, jump = 0;
        for(int i = 0; i < n-1; i++){
            int reach = i + a[i];
            max = Integer.max(max, reach);
            if(i == windowlast){
                windowlast = max;
                jump++;
                if(max >= n-1) return jump;
            }
        }
        return jump;
    }
}