class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        
        s = sb.toString().toUpperCase();

        int l = 0;
        int h = s.length()-1;
        while(l <= h){
            if(s.charAt(l) != s.charAt(h)){
                return false;
            }
            l++;h--;
        }
        return true;
    }
}