class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n;i++){
            int[] curr = intervals[i];
            //case1:new<curr
            if(newInterval[1] < curr[0]){
                list.add(newInterval);
                newInterval = curr;
            }
            //case2:new>curr
            else if(newInterval[0] > curr[1]){
                list.add(curr);
            }
            //case3:overlap
            else{
                newInterval[0] = Integer.min(newInterval[0], curr[0]);
                newInterval[1] = Integer.max(newInterval[1], curr[1]);
            }
        }  
        list.add(newInterval);

        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}

