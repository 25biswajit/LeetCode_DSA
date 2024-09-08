class Solution {
    public int firstMissingPositive(int[] a) {
        int n = a.length;
        int i = 0;
        while(i < n){
            if(a[i] <= 0 || a[i]>n) i++;
            else if(a[i]-1 == i) i++;
            else if(a[i] == a[ a[i]-1 ]) i++;
            else swap(a, a[i]-1, i);
        }
        i = 0;
        while(i < n){
            if(a[i]-1 != i) break;
            i++; 
        }
        return i+1;
    }

    void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}