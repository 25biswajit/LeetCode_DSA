class Solution {
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        int l = 0, h = n - 1, index = 0;
        while(l <= h){
            index = kthLargest(a, l, h);
            if(index == k-1){
                break;
            }
            else if(index > k-1){
                h = index - 1;
            }else{
                l = index + 1;
            }
        }
        return a[index];
    }

    int kthLargest(int[] a, int l, int h){
        int p = l;
        l = l + 1;
        while(l <= h){
            if(a[l] < a[p] && a[h] > a[p]){
                swap(a,l,h);
                l++;
                h--;
            }
            if(a[l] >= a[p]){
                l++;
            }
            if(a[h] <= a[p]){
                h--;
            }
        }
        swap(a, p, h);
        return h;
    }

    void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}