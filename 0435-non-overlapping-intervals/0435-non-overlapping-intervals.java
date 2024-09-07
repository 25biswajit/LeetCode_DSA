class Solution {
    public int eraseOverlapIntervals(int[][] all) {
        //Step1: Sort by end time
        Arrays.sort(all, (a,b)-> a[1]-b[1]);

        //Step2: if overlapping count++
        int n = all.length, count = 0;
        int[] last = all[0];
        for(int i = 1; i < n; i++){
            if(last[1] <= all[i][0]){
                last = all[i];
            }else{
                count++;
            }
        }
        return count;
    }
}