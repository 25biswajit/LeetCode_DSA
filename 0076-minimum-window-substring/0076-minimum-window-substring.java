class Solution {
    public String minWindow(String s, String t) {
        int i = 0, j = 0, n = s.length();
        if(t.length() > n) return "";
        int minWindowSize = n+1, startWindowIndex = 0;
        int countReq = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        while (j < n){
            char c = s.charAt(j);

            if(map.getOrDefault(c,0) > 0){
                countReq--;
            }

            map.put(c, map.getOrDefault(c,0)-1);

            // start shrinking the window
            while (countReq == 0 && i <= j){
                int window = j - i + 1;
                if(window < minWindowSize){
                    minWindowSize = window;
                    startWindowIndex = i;
                    System.out.println("window" + window + " maxwindow:" + minWindowSize + " StartIndex:" + startWindowIndex);
                }

                c = s.charAt(i);
                map.put(c, map.getOrDefault(c,0)+1);

                if(map.getOrDefault(c,0) > 0){
                    countReq++;
                }
                i++;
            }

            j++;
        }
        System.out.println(" maxwindow:" + minWindowSize + " StartIndex:" + startWindowIndex );
        if(minWindowSize == n+1) return "";
        return s.substring(startWindowIndex, startWindowIndex+minWindowSize);
    }
}