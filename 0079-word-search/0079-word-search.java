class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(match(board, i, j, m, n, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean match(char[][] board, int i, int j, int m, int n, String word, int k){
        if(k >= word.length()) return true;
        char c = word.charAt(k);
        if(!(m > i && i >= 0 && n > j && j >= 0)) return false;

        char curr = board[i][j];
        if(curr != c || curr =='.' ) return false;
        board[i][j] = '.';
        boolean result = match(board, i-1, j, m, n, word, k+1)
                         || match(board, i+1, j, m, n, word, k+1)
                         || match(board, i, j-1, m, n, word, k+1)
                         || match(board, i, j+1, m, n, word, k+1);
        board[i][j] = curr;
        return result;

    }
}