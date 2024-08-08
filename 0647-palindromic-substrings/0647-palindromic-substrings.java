class Solution {
    int count;
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i = 0; i < n; i++){
            expand(arr,i,i,n);
            expand(arr,i,i+1,n);
        }
        return count;
    }

    void expand(char[] a, int i, int j, int n){
        while(i >= 0 && j < n && a[i] == a[j]){
            count++;
            i--;
            j++;
        }
    }
}