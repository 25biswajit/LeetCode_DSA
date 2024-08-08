class Solution {
    boolean[][] dp = null;
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        dp = new boolean[n][n];
        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len <= n; i++){
                int j = i + len - 1;
                boolean flag = s.charAt(i)==s.charAt(j);
                // len 1 & 2
                if(len <= 2) dp[i][j] = flag;
                else dp[i][j] = dp[i+1][j-1] && flag;

                if(dp[i][j]) count++;
            }
        }
        return count;
    }
}