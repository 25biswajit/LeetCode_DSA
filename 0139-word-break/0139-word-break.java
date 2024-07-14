class Solution {
    Map<String, Boolean> map = null;
    Set<String> set = null;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        set = new HashSet<String>(wordDict);
        map = new HashMap<>();
        return solve(s);
    }

    private boolean solve(String s){
        boolean result = false;
        int n = s.length();
        if(n == 0) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i = 1; i <= n; i++){
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if(set.contains(prefix) && solve( suffix )){
                result = true;  
            }
            map.put(s, result);
        }
        return result;
    }
}