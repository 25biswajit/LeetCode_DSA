class Solution {
    public int[][] merge(int[][] all) {
        Arrays.sort(all, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        int n = all.length;
        int[] prev = all[0];
        for(int i = 1; i < n; i++){
            int[] curr = all[i];
            if(prev[1] < curr[0]){
                list.add(prev);
                prev = curr;
            }
            else{
                prev[0] = Integer.min(prev[0], curr[0]);
                prev[1] = Integer.max(prev[1], curr[1]);
            }
        }
        list.add(prev);
        n = list.size();
        int[][] ans = new int[n][];
        for(int i = 0; i<n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}