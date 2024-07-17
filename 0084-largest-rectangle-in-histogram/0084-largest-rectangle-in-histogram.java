class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsi = new int[n];
        int[] psi = new int[n];
        Arrays.fill(psi, -1);
        Arrays.fill(nsi, n);
        prepareNextSmallerIndex(heights, nsi);
        preparePrevSmallerIndex(heights, psi);
        int max = 0;
        for(int i = 0; i < n ;i++){
            int len = nsi[i] - psi[i] - 1;
            int bre = heights[i];
            int area = len * bre;
            max = Integer.max(max, area);
        }
        return max;
    }

    private void prepareNextSmallerIndex(int[] h, int[] nsi){
        Stack<Integer> stack = new Stack<>();
        int n = h.length;
        int i = n -1;
        while(i >=0){
            if(stack.isEmpty()){ stack.push(i); i--;}
            //stack not Empty()
            else{
                int top = h[stack.peek()];
                if(top < h[i]) {
                    nsi[i] = stack.peek();
                    stack.push(i);
                    i--;
                }else{
                    while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                        stack.pop();
                    }
                }
            }
        }
    }

    private void preparePrevSmallerIndex(int[] h, int[] psi){
        Stack<Integer> stack = new Stack<>();
        int n = h.length;
        int i = 0;
        while(i < n){
            if(stack.isEmpty()){ stack.push(i); i++;}
            //stack not Empty()
            else{
                int top = h[stack.peek()];
                if(top < h[i]) {
                    psi[i] = stack.peek();
                    stack.push(i);
                    i++;
                }else{
                    while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                        stack.pop();
                    }
                }
            }
        }
    }
}