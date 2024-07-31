class Solution { 
    int dp[][] = null;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return minDistance(word1, word2, n-1, m-1);
    }

    int minDistance(String s1, String s2, int i, int j){
        if(i < 0 && j < 0) return 0;
        // source word is smaller than target word
        if(i < 0 && j >= 0) return j+1;
        // target word is smaller than source word
        if(j < 0 && i >= 0) return i+1;
        
        if(dp[i][j] != -1) return dp[i][j];

        // both having same char no operation required
        if(s1.charAt(i)==s2.charAt(j)) {
            dp[i][j] = minDistance(s1, s2, i-1, j-1);
        }
        // both having diff char apply insert, delete, replace and pick min
        else{
            int insert = 1 + minDistance(s1, s2, i, j-1);
            int delete = 1 + minDistance(s1, s2, i-1, j);
            int replace = 1 + minDistance(s1, s2, i-1, j-1);
            dp[i][j] = Integer.min( insert, Integer.min(delete, replace));
        }

        return dp[i][j];
    }
}