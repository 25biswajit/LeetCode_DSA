class Solution {
    public int findDuplicate(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++){
            int pos = Math.abs(a[i]);
            if(a[pos - 1] < 0){
                return pos;
            }else{
                a[pos - 1] = a[pos - 1] * -1; 
            }
        }
        return -1;
    }
}