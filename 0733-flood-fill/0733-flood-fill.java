class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs_(image, sr, sc, originalColor, color);
        }
        return image;
    }

    void dfs_(int[][] grid, int i, int j, int orginal, int target){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != orginal) return;
        grid[i][j] = target;
        dfs_(grid, i - 1, j , orginal, target);
        dfs_(grid, i + 1, j , orginal, target);
        dfs_(grid, i , j - 1, orginal, target);
        dfs_(grid, i , j + 1 , orginal, target);
    }
}