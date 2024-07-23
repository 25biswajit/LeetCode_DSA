class Solution {
    public int removeDuplicates(int[] a) {
        int slow = 0, fast = 0;
        int n = a.length;
        while(fast < n){
            if(a[slow] != a[fast]) {
                slow++;
                a[slow] = a[fast];
            }
            fast++;
        }
        return slow+1;
    }
}