class Solution {
    List<List<String>> list = null;
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        int[][] grid = new int[n][n];
        nqueen(0, grid, n);
        return list;
    }

    public void nqueen(int r, int[][] grid, int n){
        if(r == n){
            print(grid);
        }

        for(int j = 0; j < n; j++){
            if(isSafe(grid,r,j)){
                grid[r][j] = 1;
                nqueen(r+1, grid, n);
                grid[r][j] = 0;
            }
        }
    }

    private void print(int [][] grid){
        List<String> ans = new ArrayList<>();
        int n = grid.length;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        list.add(ans);
    }

    private boolean isSafe(int[][] grid, int r, int c){
        int n = grid.length;
        if(!isWithinGrid(r,c,n)){
            return false;
        }

        // colwise
        for(int i = 0; i < n; i++){
            if(grid[i][c] == 1){
                return false;
            }
        }
        //row wise
        for(int j = 0; j < n; j++){
            if(grid[r][j] == 1){
                return false;
            }
        }
        // diag 1
        int i = r, j = c;
        while(isWithinGrid(i,j,n)){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        // diag 2
        i = r; j = c;
        while(isWithinGrid(i,j,n)){
            if(grid[i][j] == 1){
                return false;
            }
            i++;
            j--;
        }
        // diag 3
        i = r; j = c;
        while(isWithinGrid(i,j,n)){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        // diag 4
        i = r; j = c;
        while(isWithinGrid(i,j,n)){
            if(grid[i][j] == 1){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private boolean isWithinGrid(int r, int c, int n){
        if(r < 0 || r >= n || c < 0 || c >= n){
            return false;
        }
        return true;
    }
}