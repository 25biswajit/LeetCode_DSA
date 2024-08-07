class Solution {
    public int canCompleteCircuit(int[] g, int[] c) {
        int n = g.length;
        int gas = 0, cost = 0, index = -1, consume = 0;
        for(int i = 0; i < n; i++){
            gas += g[i];
            cost += c[i];
            consume += g[i] - c[i];
            if(consume < 0){
                consume = 0;
                index = -1;
            }
            else if(consume >= 0 && index == -1){
                index = i;
            }
        }
        return gas >= cost ? index : -1;
    }
}