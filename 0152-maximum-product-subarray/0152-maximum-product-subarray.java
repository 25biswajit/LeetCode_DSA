class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int product = 1;
        for(int i = 0; i < n; i++){
            product *= arr[i];
            ans = Integer.max(ans, product);
            product = product == 0 ? 1 : product;
        }

        product = 1;
        for(int i = n-1; i >= 0; i--){
            product *= arr[i];
            ans = Integer.max(ans, product);
            product = product == 0 ? 1 : product;
        }
        return ans;
    }
}