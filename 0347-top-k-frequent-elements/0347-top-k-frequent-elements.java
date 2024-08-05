class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
            maxFreq = Integer.max( maxFreq, map.get(i));
        }
        
        List<Integer>[] buckets = new ArrayList[maxFreq + 1];
        for(Integer key : map.keySet()){
            int index = map.get(key);
            if(buckets[ index ] == null){
                buckets[ index ] = new ArrayList<>();
            }
            buckets[ index ].add(key);
        }

        int[] ans = new int[k];
        int i = 0;

        for(int j = maxFreq; j >= 0 && i < k; j--){
            if(buckets[ j ] != null){
                for(int num : buckets[ j ]){
                    ans[i++] = num;
                }
            }
        }

        return ans;
    }


    public int[] topKFrequent_pq(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(Integer i : map.keySet()){
            pq.add(new int[]{ i, map.get(i)});
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream().mapToInt(i -> i[0]).toArray();
    }

    public int[] topKFrequent_old(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        return map.entrySet().stream()
                            .sorted((a,b)->b.getValue() - a.getValue())
                            .mapToInt(i -> i.getKey())
                            .limit(k)
                            .toArray();
    }
}