class Solution {
    public boolean searchMatrix(int[][] m, int k) {
        int r = m.length;
        int c = m[0].length;
        int i = 0;
        int j = c - 1;
        while(i < r && j >= 0){
            if(m[i][j] < k){
                i++;
            }
            else if(m[i][j] > k){
                j--;
            }
            else{
                //m[i][j] == k)
                return true;
            }
        }
        return false;
    }
}