class Solution {
    public int eraseOverlapIntervals(int[][] all) {
        //Arrays.sort(all, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Arrays.sort(all, (a,b) -> a[1]-b[1]);
        int count = 0, n = all.length;
        int[] last = all[0];
        for(int i = 1; i < n; i++){
            if(last[1] <= all[i][0]){
                last = all[i];
            }
            else{
                count++;
            }
        }
        return count;
    }
}