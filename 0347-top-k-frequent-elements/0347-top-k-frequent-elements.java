class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
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