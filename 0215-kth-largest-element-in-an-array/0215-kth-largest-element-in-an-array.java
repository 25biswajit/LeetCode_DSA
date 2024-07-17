class Solution {

    public int findKthLargest(int[] nums, int k) {
       return findKthLargestQuickSort(nums, k); 
    }

    public int findKthLargestQuickSort(int[] nums, int k) {
        int high = nums.length - 1;
        int low = 0;
        while(low <= high){
            int p = partition(nums, low, high);
            if(p == k-1) return nums[p];
            if(p > k - 1) high = p - 1;
            else low = p + 1;
        }
        return -1;
    }

    private int partition(int[] a, int s, int e){
        int p = s;
        s++;
        while(s <= e){
            if(a[p] > a[s] && a[e] > a[p]){
                swap(a, s, e);
                s++;
                e--;
            }
            if(a[p] <= a[s]){
                s++;
            }
            if(a[p] >= a[e]){
                e--;
            }
        }
        swap(a, p, e);
        return e;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int findKthLargestMinHeap(int[] nums, int k) {
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