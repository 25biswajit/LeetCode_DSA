class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        String ans1,ans2,ans,palStr = "";
        for(int i = 0; i < n; i++){
            ans1 = expand(arr,i,i,n);
            ans2 = expand(arr,i,i+1,n);
            ans = ans1.length() > ans2.length() ? ans1: ans2;
            palStr = ans.length() > palStr.length() ? ans : palStr;
        }
        return palStr;
    }

    String expand(char[] a, int i, int j, int n){
        String ans = "";
        while(i >= 0 && j < n && a[i] == a[j]){
            if(i == j) ans += a[i];
            else ans = a[i] + ans + a[j];
            i--;
            j++;
        }
        return ans;
    }
}