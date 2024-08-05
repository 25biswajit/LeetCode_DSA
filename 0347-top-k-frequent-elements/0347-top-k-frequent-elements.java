class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        return map
        .entrySet()
        .stream()
        .sorted((a,b)->b.getValue() - a.getValue())
        .mapToInt(i -> i.getKey())
        .limit(k)
        .toArray();
    }
}