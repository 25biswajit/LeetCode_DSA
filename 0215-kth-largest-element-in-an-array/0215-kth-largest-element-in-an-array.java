class Solution {
    public int findKthLargest(int[] nums, int k) {
        int s = 0, e = nums.length - 1, index = -1;
        while(s <= e){
            index = quickSelect(nums, s, e);
            if(index == k-1) break;
            else if(index > k-1) e = index - 1;
            else s = index + 1;
        }
        return nums[index];
    }

    public int quickSelect(int[] a, int s, int e){
        int p = s;
        s++;
        while(s <= e){
            if(a[s] < a[p] && a[e] > a[p]){
                swap(a, s, e);
                s++;
                e--;
            }
            if(a[s] >= a[p]){
                s++;
            }
            if(a[e] <= a[p]){
                e--;
            }
        }
        swap(a, p, e);
        return e;
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}