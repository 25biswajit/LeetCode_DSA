class Solution {
    public int[] twoSum(int[] a, int t) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for(int i = 0 ; i < n; i ++){
            int j = t - a[i];
            if(map.containsKey(j)){
                return new int[]{map.get(j), i};
            }
            map.put(a[i],i);
        }
        return null;
    }
}