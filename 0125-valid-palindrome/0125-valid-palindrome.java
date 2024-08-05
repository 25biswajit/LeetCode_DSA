class Solution {
    public boolean isPalindrome(String s) {
         s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome_(String s) {
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