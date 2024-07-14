class Solution {
    Map<String, Integer> map = null;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return ways(s);
    }

    private int ways(String s){
        int n = s.length();
        if(n == 0) return 1;
        if(s.charAt(0)=='0') return 0;
        if(map.containsKey(s)) return map.get(s);

        int result = 0;
        String s1 = s.substring(0,1);
        result += ways(s.substring(1));

        String s2 = null;
        if(n > 1){
            s2 = s.substring(0,2);
            int num = Integer.parseInt(s2);
            if(num <= 26){
                result += ways(s.substring(2));
            }
        }

        map.put(s, result);
        return result;
    }
}