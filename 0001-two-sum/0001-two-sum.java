class Solution {
    public int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < a.length; i++){
            int rest = target - a[i];
            if(map.containsKey(rest)){
                return new int[] { map.get(rest), i };
            }
            map.put(a[i], i);
        }
        return new int[]{};
    }
}