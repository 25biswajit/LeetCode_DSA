class Solution {
    public boolean isValidSudoku(char[][] b) {
        int m = b.length, n = b[0].length;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(b[i][j]!='.'){
                    String rowEntry = "ROW"+"_"+i+"_"+b[i][j];
                    String colEntry = "COL"+"_"+j+"_"+b[i][j];
                    int boxId = (i/3) * 3 + j/3;
                    String boxEntry = "BOX"+"_"+boxId+"_"+b[i][j];

                    if(!set.add(rowEntry) || !set.add(colEntry) || !set.add(boxEntry) ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}