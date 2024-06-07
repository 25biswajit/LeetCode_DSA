import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        List<List<Integer>> list = new ArrayList<>();
        if (h == null || h.length == 0 || h[0].length == 0) return list;
        
        int row = h.length;
        int col = h[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // DFS
        // Row-wise
        for (int i = 0; i < row; i++) {
            dfs(h, i, 0, Integer.MIN_VALUE, row, col, pacific);
            dfs(h, i, col - 1, Integer.MIN_VALUE, row, col, atlantic);
        }
        // Column-wise
        for (int i = 0; i < col; i++) {
            dfs(h, 0, i, Integer.MIN_VALUE, row, col, pacific);
            dfs(h, row - 1, i, Integer.MIN_VALUE, row, col, atlantic);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;
    }

    private void dfs(int[][] h, int i, int j, int prev, int row, int col, boolean[][] ocean) {
        if (i < 0 || i >= row || j < 0 || j >= col || h[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        for (int[] d : dirs) {
            dfs(h, i + d[0], j + d[1], h[i][j], row, col, ocean);
        }
    }
}