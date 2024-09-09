class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0, rotten = 0, time = 0;
        Queue<Pair> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                if(grid[i][j]==2){
                    rotten++;
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return time;
        while(!q.isEmpty() && fresh > 0){
            int n = q.size();
            time++;
            for(int i = 0; i < n;i++){
                Pair top = q.poll();
                for(int[] d : dirs){
                    int x = d[0] + top.row;
                    int y = d[1] + top.col;
                    if(x >= 0 && x < r && y >=0 && y < c && grid[x][y] == 1){
                        q.add(new Pair(x,y));
                        fresh--;
                        grid[x][y] = 2;
                    }
                }
            } 
        }
        return fresh > 0 ? -1 : time;
    }
}

class Pair{
    int row,col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}