class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int n = intervals.length;
        int[] curr = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int[] temp = intervals[i];

            //CASE 1 - Curr Before Temp
            if(curr[1] < temp[0]){
                list.add(curr);
                curr = temp;
            }
            //Case 2 - After - NP

            //Case 3 - Overlap
            else{
                curr[0] = Integer.min(curr[0], temp[0]);
                curr[1] = Integer.max(curr[1], temp[1]);
            }
        }
        list.add(curr);
        int[][] result = new int[list.size()][];
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}