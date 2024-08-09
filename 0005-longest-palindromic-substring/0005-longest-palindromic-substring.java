class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;  // Length of the longest palindrome found
        int start = 0;      // Start index of the longest palindrome
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                boolean flag = s.charAt(i) == s.charAt(j);
                
                // For substrings of length 1 and 2
                if (len <= 2) {
                    dp[i][j] = flag;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && flag;
                }
                
                // If it's a palindrome and longer than the previous found
                if (dp[i][j] && len > maxLength) {
                    start = i;
                    maxLength = len;
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}