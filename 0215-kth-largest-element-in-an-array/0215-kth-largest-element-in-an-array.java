class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}