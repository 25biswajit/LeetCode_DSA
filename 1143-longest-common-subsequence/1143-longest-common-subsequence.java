class Solution {
    int[][] dp = null;
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        return lcs(s1,s2,m-1,n-1);
    }
    int lcs(String s1, String s2, int i, int j){
        if(i<0 || j <0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res;
        if(s1.charAt(i) == s2.charAt(j)) {
            res = 1 + lcs(s1,s2,i-1,j-1);
        }else{
            res = Integer.max(lcs(s1,s2,i-1,j), lcs(s1,s2,i,j-1));
        }
        return dp[i][j] = res;
    }
}