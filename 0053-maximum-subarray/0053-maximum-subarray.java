class Solution {
    public int maxSubArray(int[] a) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i : a){
            sum += i;
            maxSum = Integer.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}