class Solution {
    public int firstMissingPositive(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++){
            if(0 >= a[i] || a[i] > n) continue;
            else if(i == a[i]-1) continue;
            else if(a[i] == a[a[i]-1]) continue;
            else {
                swap(a, i, a[i]-1);
                i--;
            }    
        }

        int i = 0;
        int missing = 1;
        while(i < n && missing == a[i]){
            i++;
            missing++;
        }

        return missing;
    }

    void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}