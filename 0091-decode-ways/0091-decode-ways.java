class Solution {
    Map<String, Integer> map = null;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return decode(s);
    }

    int decode(String s){
        int n = s.length();
        if(n == 0) return 1;
        if(map.containsKey(s)) return map.get(s);
        if(n > 0 && s.charAt(0)=='0') return 0;
        //if(n == 1) return 1;
        //int num = Integer.parseInt(s);
        //if(n == 2 && num >=11 && num<= 26) return 2;
        
        int ways = decode( s.substring(1) );
        if(n >= 2 && isValid(s.substring(0,2))){
            ways += decode(s.substring(2));
        }
        map.put(s, ways);
        return ways;
    }
    
    boolean isValid(String s){
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }

}