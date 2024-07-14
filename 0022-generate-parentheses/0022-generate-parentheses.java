class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        solve(n, list, sb, 1, 0);
        return list;
    }

    private void solve(int n, List<String> list, StringBuffer sb, int open, int close){
        int l = sb.length();
        if(l == n*2) {
            list.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            solve(n, list, sb, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }    

        if(close < open){
            sb.append(")");
            solve(n, list, sb, open, close + 1);
            sb.deleteCharAt(sb.length()-1);
        }    
    }
}