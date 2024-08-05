class Solution {
    public int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int s = 0, e = 0, n = str.length(), maxlen = 0;

        while(e < n){
            char ch = str.charAt(e);
            while(set.contains(ch)){
                set.remove(str.charAt(s));
                s++;
            }
            if(!set.contains(ch)){
                set.add(ch);
            }
            maxlen = Integer.max(maxlen, set.size());
            e++;
        }

        return maxlen;
    }
}