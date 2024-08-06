class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int reqCount = t.length();
        int n = s.length();
        if(reqCount > n) return "";
        int i = 0, j = 0;
        int maxWindowSize = n+1, index = -1;

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        while(j < n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)-1);

            if(map.get(ch) >= 0){
                reqCount--;
            }
            System.out.println("reqCount :" + reqCount);
            while(reqCount == 0 && i <= j){
                ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                
                if(map.get(ch) > 0){
                    reqCount++;
                }

                int currWindow = j - i + 1;
                System.out.println("Window :" + currWindow + " Size:" + maxWindowSize);
                if(currWindow < maxWindowSize){
                    maxWindowSize = currWindow;
                    index = i;
                }
                i++;
            }

            j++;
        }
        if(maxWindowSize == n+1) return "";
        return s.substring(index, index + maxWindowSize);
    }
}