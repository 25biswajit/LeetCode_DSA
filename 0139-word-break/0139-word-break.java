class Solution {
    Set<String> set = null;
    Map<String, Boolean> dp = null;
    public boolean wordBreak(String s, List<String> wordDict) {  
        set = wordDict.stream().collect(Collectors.toSet());
        dp = new HashMap<>();
        return solve(s);
    }

    boolean solve(String s){
        int n = s.length();
        if(n == 0) return true;
        if(dp.containsKey(s)) return dp.get(s);

        for(int i = 1; i <= n; i++){
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if(set.contains(prefix) && solve(suffix)){
                dp.put(s, true);
                break;
            }
        }
        dp.putIfAbsent(s, false);
        return dp.get(s);
    }
}