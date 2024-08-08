class Solution {
    public int maxSubarrayLength(int[] a, int k) {
        int i = 0, j= 0, len = 0, n = a.length;
		Map<Integer, Integer> map = new HashMap<>();
		while(j < n){
			int num = a[j];
			map.put(num, map.getOrDefault(num, 0)+1);

			while(map.get(num)>k){
				int num_ = a[i];
				map.put(num_, map.getOrDefault(num_, 0)-1);
				i++;
			}

			len = Integer.max(len, j-i+1);
			j++;
		}
		return len;
    }
}