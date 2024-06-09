class Solution {
    int count;
    public int reversePairs(int[] nums) {
        count = 0;
        int s = 0, e = nums.length - 1;
        mergeSort(nums, s, e);
        return count/2;
    }

    private void mergeSort(int[] a, int s, int e){
        if(s == e) return;
        int mid = (s + e) / 2;
        mergeSort(a, s, mid);
        mergeSort(a, mid+1, e);
        countReservePair(a, s, mid, e);
        merge(a, s, mid, e);
    }

    private void merge(int[] a, int s, int m, int e){
        List<Integer> list = new ArrayList<>();
        int i = s, j = m+1;
        while(i <= m && j <= e){    
            if(a[i] > a[j]){
                list.add(a[j]);
                j++;
            }else{
                list.add(a[i]);
                i++;
            }
        }
        while(i <= m) list.add(a[i++]);
        while(j <= e) list.add(a[j++]);
        int k = 0;
        for(i = s; i <= e; i++){
            a[i] = list.get(k);
            k++;
        }
    }

    private void countReservePair(int[] a, int s, int m, int e){
        int j = m + 1;
        for(int i = s; i <= e; i++){
            while(j <= e && a[i] > (2L * a[j])) j++;
            count += j - (m+1);
        }
    }
}