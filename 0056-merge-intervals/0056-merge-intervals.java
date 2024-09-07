class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int n = intervals.length;
        int[] temp = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];
            if(temp[1] < curr[0]){
                list.add(temp);
                temp = curr;
            }
            else{
                temp[0] = Integer.min(temp[0], curr[0]);
                temp[1] = Integer.max(temp[1], curr[1]);
            }
        }
        list.add(temp);
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}