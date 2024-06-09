class Solution {
    public boolean wordBreak(String s, List<String> dic) {
        int n = s.length();
        Map<String, Boolean> dp = new HashMap<>();
        return wordBreak(s, dic, dp);
    }

    private boolean wordBreak(String s ,List<String> dic, Map<String, Boolean> dp){
        int n = s.length();
        if(n == 0) return true;
        if(dp.containsKey(s)) return dp.get(s);
        boolean result = false;
        for(int i = 1; i <= n; i++){
            String substring = s.substring(0, i);
            String rest = s.substring(i);
            if( dic.contains(substring) && wordBreak(rest, dic, dp)){
                dp.put(s, true);
                result = true;
                break;
            }else{
                dp.put(s, false);
            }
        }
        return dp.get(s);
    }

}