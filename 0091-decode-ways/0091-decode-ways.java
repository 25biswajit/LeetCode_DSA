class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> map = new HashMap<>();
        return count(s, map);
    }

    private int count(String s, Map<String, Integer> map){
        int n = s.length();
        if( n == 0 ) return 1;
        if( s.startsWith("0") ) return 0;
        if( map.containsKey(s) ) return map.get(s);
        
        int result = count(s.substring(1), map);

        if(n >= 2){
            String two = s.substring(0, 2);
            if(valid(two)){
                result += count(s.substring(2), map);
            }
        }
        
        map.put(s, result);
        return result;
    }

    private boolean valid(String s){
        return !(Integer.parseInt(s) > 26);
    }
}