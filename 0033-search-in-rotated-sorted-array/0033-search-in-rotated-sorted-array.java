class Solution {
    public int search(int[] a, int k) {
        int low = 0, high = a.length-1;
        while(low <= high){
            int mid = (low + high) / 2;

            if(a[mid] == k){
                return mid;
            }
            else if(a[low] <= a[mid]){
                if(a[low] <= k && k < a[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            else if(a[mid] <= a[high]){
                if(a[mid] < k && k <= a[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        } 
        return -1;
    }
}