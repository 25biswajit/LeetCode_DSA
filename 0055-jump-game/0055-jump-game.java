class Solution {
    public boolean canJump(int[] a) {
        int reachable = 0, n = a.length;
        for(int i = 0; i < n; i++){
            if(reachable < i){
                return false;
            }
            reachable = Integer.max( reachable , i+a[i]);
        }
        return true;
    }
}