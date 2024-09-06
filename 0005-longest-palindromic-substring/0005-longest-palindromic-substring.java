class Solution {
    private int start;
    private int maxLength;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            // Check for odd-length palindromes centered at i
            expand(arr, i, i, n);
            // Check for even-length palindromes centered between i and i+1
            expand(arr, i, i + 1, n);
        }

        return s.substring(start, start + maxLength);
    }

    private void expand(char[] arr, int i, int j, int n) {
        while (i >= 0 && j < n && arr[i] == arr[j]) {
            int currentLength = j - i + 1;
            if (currentLength > maxLength) {
                start = i;
                maxLength = currentLength;
            }
            i--;
            j++;
        }
    }
}
