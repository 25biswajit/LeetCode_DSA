class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int[] curr = intervals[i];
            //newInt after
            if(newInterval[0] > curr[1]){
                list.add(curr);
            }
            //newInt before
            else if(newInterval[1] < curr[0]){
                list.add(newInterval);
                newInterval = curr;
            }
            //overlap
            else{
                newInterval[0] = Integer.min(newInterval[0], curr[0]);
                newInterval[1] = Integer.max(newInterval[1], curr[1]);
            }
        }
        list.add(newInterval);

        int[][] res = new int[list.size()][2];
        int i = 0;
        for(int[] p : list){
            res[i++] = p;
        }
        return res;
    }
}