class Solution {
    public String longestPalindrome(String s) {
        String result = "", temp = "", odd = "", even = "";
        int n = s.length();
        for(int i = 0; i < n; i++){
            even = expand(s, i, i+1);
            odd = expand(s, i, i);
            temp = even.length() > odd.length() ? even : odd;
            result = result.length() > temp.length() ? result : temp;
        }
        return result;
    }

    public String expand(String s, int i, int j){
        int n = s.length();
        String ans = "";
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            if(i==j){
                ans = s.charAt(i) + ans; 
            }else{
                ans = s.charAt(i) + ans + s.charAt(j);
            }
            i--;
            j++;
        }
        return ans;
    }
}