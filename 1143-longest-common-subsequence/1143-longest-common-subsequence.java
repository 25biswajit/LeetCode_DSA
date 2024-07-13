class Solution {
    int[][] dp = null;
    int result = 0;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m+1][n+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d,-1));
        return lcs(text1, m, text2, n, 0, 0);
    }

    private int lcs(String s1, int m, String s2, int n, int i, int j){
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + lcs(s1,m,s2,n,i+1,j+1);
        }
        else{
            dp[i][j] = Integer.max( lcs(s1,m,s2,n,i+1,j) , lcs(s1,m,s2,n,i,j+1));
        }
        return dp[i][j];
    }
}