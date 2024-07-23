class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       int n = intervals.length;
       List<int[]> list = new ArrayList<>();
       for(int i =0; i < n;i++){
            int[] temp = intervals[i];

            //case1 - new < temp
            if(newInterval[1] < temp[0]){
                list.add(newInterval);
                newInterval = temp;
            }
            //case2 - new > temp
            else if(newInterval[0] > temp[1]){
                list.add(temp);
            }
            //case3 - overlapping
            else{
                newInterval[0] = Integer.min(newInterval[0], temp[0]);
                newInterval[1] = Integer.max(newInterval[1], temp[1]);
            }
       } 
       list.add(newInterval);

       n = list.size(); 
       int[][] result = new int[n][];
       for(int i = 0; i < n;i++){
            result[i] = list.get(i);
       }
       return result;
    }
}