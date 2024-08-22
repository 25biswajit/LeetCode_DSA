class Solution {
    public String decodeString(String s) {
        s = "1[" + s + "]";
        Stack<String> stack = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
        }
        if(!sb.isEmpty() && s.charAt(i)=='['){
            stack.push(sb.toString());
            sb.delete(0, sb.length());
            i++;
        }

        while(!stack.isEmpty() && i < s.length()){
            char ch = s.charAt(i);
            while(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            }
            if(!sb.isEmpty() && s.charAt(i)=='['){
                stack.push(sb.toString());
                sb.delete(0, sb.length());
                i++;
            }
            else if(ch == ']'){
                String temp = "";
                while(!stack.isEmpty() && !Character.isDigit(stack.peek().charAt(0))){
                    temp = stack.pop() + temp;
                }
                temp = convert( Integer.parseInt(stack.pop()), temp);
                stack.push(temp);
                i++;
            }else {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }
            System.out.println(stack);
        }
        return String.join("", stack);
    }

    private String convert(Integer c , String exp){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= c; i++){
            sb.append(exp);
        }
        return sb.toString();
    }
}