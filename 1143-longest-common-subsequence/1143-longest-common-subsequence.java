class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return lcs(0, 0, n, m, text1, text2, dp);
    }

    private int lcs(int i, int j, int n, int m, String s1, String s2, int dp[][]){
        if(i >= n || j>= m) return 0;
        if(dp[i][j] != -1) return dp[i][j]; 
        int res = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            res = 1 + lcs(i+1, j+1, n, m, s1, s2, dp);
        }
        else{
            int option1 = lcs(i+1, j, n, m, s1, s2, dp);
            int option2 = lcs(i, j+1, n, m, s1, s2, dp);
            res = Integer.max(option1, option2);
        }
        return dp[i][j] = res;
    }
}