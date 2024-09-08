class Solution {
    public String minWindow(String s, String t) {
        int h = 0, l = 0, len = s.length()+1, start = -1, n = s.length(), count = t.length();
        char ch = 'a';
        if(count > n) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length();i++){
            ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        while(h < n){
            ch = s.charAt(h);
            if(map.getOrDefault(ch, 0)>0){
                count--;
            }
            map.put(ch, map.getOrDefault(ch,0)-1);

            while(count == 0 && l <= h){
                int win = h - l + 1;
                if(win < len){
                    len = win;
                    start = l;
                }

                ch = s.charAt(l);
                if(map.getOrDefault(ch, 0)==0){
                    count++;
                }
                map.put(ch, map.getOrDefault(ch,0)+1);
                l++;
            }
            h++;
        }
        if(start == -1) return "";
        return s.substring(start, start+len);
    }
}