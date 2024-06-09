class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] nse = nextSmall(h);
        Arrays.stream(nse).forEach(x -> System.out.print(x +","));
        int[] pse = prevSmall(h);
        System.out.println();
        Arrays.stream(pse).forEach(x -> System.out.print(x +","));
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Integer.max( max, h[i] * (nse [i] - pse[i] - 1));
        }
        return max;
    }

    private int[] prevSmall(int[] h){
        int n = h.length;
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        while(i < n){
            if(!stack.isEmpty()){
                if( h[i] > h[stack.peek()] ){
                    pse[i] = stack.peek();
                    stack.push(i);
                    i++;
                }
                else{
                    while(!stack.isEmpty() && h[i] <= h[stack.peek()] ){
                        stack.pop();
                    }
                }
            }else{
                stack.push(i);
                i++;
            }
        }
        return pse;
    }

    private int[] nextSmall(int[] h){
        int n = h.length;
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        int i = n-2;
        while(i >= 0){
            if(!stack.isEmpty()){
                if( h[i] > h[stack.peek()] ){
                    nse[i] = stack.peek();
                    stack.push(i);
                    i--;
                }
                else{
                    while(!stack.isEmpty() && h[i] <= h[stack.peek()] ){
                        stack.pop();
                    }
                }
            }else{
                stack.push(i);
                i--;
            }
        }
        return nse;
    }
}

//     2,1,5,6,2,3
//pse. -,-,1,5,1,2  
//nse. 1,6,2,2,6,6
// stack : 2