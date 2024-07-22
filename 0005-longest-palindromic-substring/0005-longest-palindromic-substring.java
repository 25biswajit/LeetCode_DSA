class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            String odd = helper(s, i, i);
            String even = helper(s, i, i+1);
            if( odd.length() > even.length()){
                if( odd.length() > ans.length()) ans = odd;
            }
            else{
                if( even.length() > ans.length()) ans = even;
            }
        }
        return ans;
    }

    String helper(String s, int l, int r){
        int n = s.length();
        String ans = "";
        while(l >= 0 && r < n){
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);
            if(c1 == c2){
                //odd
                if(l == r){
                    ans = c1 + ans;
                }
                else {
                    ans = c1 + ans + c2;
                }
                l--;
                r++;
            }else{
                break;
            }
        }
        return ans; 
    }
}