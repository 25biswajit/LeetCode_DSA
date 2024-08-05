class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int i = 0,j = 0, n = s.length(), maxFrq = 0, window, maxWindow = 0;

        while(j < n){
            char ch = s.charAt(j);
            arr[ch - 'A']++;
            maxFrq = Integer.max( maxFrq, arr[ch - 'A']);
            
            if(j - i + 1 - maxFrq > k){
                ch = s.charAt(i);
                arr[ch - 'A']--;
                i++;
            }

            maxWindow = Integer.max( maxWindow, j - i + 1);
            j++;
        }

        return maxWindow;
    }
}