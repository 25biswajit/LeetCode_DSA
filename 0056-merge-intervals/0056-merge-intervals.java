class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        if(n == 1) return intervals;

        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int current_start = intervals[0][0];
        int current_end = intervals[0][1];
        result.add(new int[]{current_start, current_end});

        for(int i = 0; i < n; i++){
            if(current_end >= intervals[i][0]){
                current_end = Math.max(current_end, intervals[i][1]);
                int curr[] = result.get(result.size()-1);
                curr[1] = current_end;
            }
            else if(current_end < intervals[i][0]){
                result.add(intervals[i]);
                current_start = intervals[i][0];
                current_end = intervals[i][1];
            }
        }

        int[][] out = new int[result.size()][2];
        int i = 0;
        for(int[] arr : result){
            out[i] = arr;
            i++;
        }

        return out;
    }
}