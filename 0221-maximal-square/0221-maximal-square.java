class Solution {
    public int maximalSquare(char[][] m) {
        int row = m.length;
        int col = m[0].length;
        int max = 0;
        int dp[][] = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(m[i][j] == '1'){
                    if(i == 0 || j == 0 ){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 1 + min (
                            dp[i-1][j],
                            dp[i][j-1],
                            dp[i-1][j-1]
                        );
                    }
                    max = Math.max( dp[i][j], max);
                }
            }
        }

        return max * max;
    }

    private int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }

    public int maximalSquare_(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ds[][] = new int[n][m];
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i==0 || j==0) {
                    if (matrix[i][j]=='1') {
                        ds[i][j] = 1;
                        ans = Math.max(ans,ds[i][j]);
                    }
                }
                else {
                    if (matrix[i][j]=='1') {
                        ds[i][j] = Math.min(ds[i-1][j-1],Math.min(ds[i][j-1],ds[i-1][j]))+1;
                        ans = Math.max(ans,ds[i][j]);
                    }
                }
            }
        }
        return ans*ans;
    }
    
}