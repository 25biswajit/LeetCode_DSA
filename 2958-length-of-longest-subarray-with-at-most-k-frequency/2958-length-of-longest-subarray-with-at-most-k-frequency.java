class Solution {
    public int maxSubarrayLength(int[] a, int k) {
        int h = 0, l = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        while(h < n){
            int c = a[h];
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.getOrDefault(c, 0) > k){
                int d = a[l];
                map.put(d, map.getOrDefault(d, 0)-1);
                if(map.get(d) <= 0){
                    map.remove(d);
                }
                l++;
            }
            ans = Integer.max(ans, h - l + 1);
            h++;
        }
        return ans;
    }
}