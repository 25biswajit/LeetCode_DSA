class Solution {
    int[][] dp = null;
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        dp = new int[n1+1][n2+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        return lcs(s1,s2,0,0,n1,n2);
    }

    int lcs(String s1, String s2, int i, int j, int n1, int n2){
        if(i >= n1 || j >= n2) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if(s1.charAt(i) == s2.charAt(j)) {
            res = 1 + lcs(s1,s2,i+1,j+1,n1,n2);
        }    
        else{
            res = Integer.max(lcs(s1,s2,i+1,j,n1,n2), lcs(s1,s2,i,j+1,n1,n2));
        }
        return dp[i][j] = res;
    }
}