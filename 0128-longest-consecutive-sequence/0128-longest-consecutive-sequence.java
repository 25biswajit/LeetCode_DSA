class Solution {
    public int longestConsecutive(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a){
            map.put(i, 0);
        }
        for(int key : map.keySet()){
            if(!map.containsKey(key-1)){
                map.put(key, 1);
            }
        }
        int maxlen = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                int len = 0;
                while(map.containsKey(key)){
                    len++;
                    maxlen = Integer.max(maxlen, len);
                    key++;
                }
            }    
        }
        return maxlen;
    }
}