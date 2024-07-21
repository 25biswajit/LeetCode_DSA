class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q = queries.length;
        int l = logs.length;
        int[] result = new int[q];
        int[][] sortedQueries = new int[q][2];
        for(int i = 0; i < q; i++){
            sortedQueries[i] = new int[]{i, queries[i]};
        }
        Arrays.sort(sortedQueries, (a,b) -> a[1]-b[1]);
        Arrays.sort(logs, (a,b) -> a[1]-b[1]);

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        for(int i = 0; i < q; i++){
            int startTime = sortedQueries[i][1] - x;
            int endTime = sortedQueries[i][1];
            int qIndex = sortedQueries[i][0];

            while(right < l && logs[right][1] <= endTime ){
                map.put( logs[right][0], map.getOrDefault(logs[right][0], 0)+1 );
                right++;
            }
            while(left < right && logs[left][1] < startTime ){
                map.put( logs[left][0], map.getOrDefault(logs[left][0], 0)-1 );
                if(map.get(logs[left][0]) <= 0) map.remove( logs[left][0] );
                left++;
            }

            result[qIndex] = n - map.size();
        }

        return result;
    }
    
    public int[] countServers_naive(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b) -> a[1]-b[1]);

        for(int i = 0; i < queries.length; i++){

            int start = queries[i] - x;
            int end = queries[i];

            HashSet<Integer> set = new HashSet<>();

            for(int[] log : logs){
                if(start <=log[1] && log[1] <= end){
                    set.add(log[0]);
                }
                else if(log[1] > start){
                    break;
                }
            }

            queries[i] = n - set.size();
        }
        return queries;
    }
}