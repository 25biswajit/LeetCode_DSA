class Solution {
    int count = 0;
    public int reversePairs(int[] a) {
        mergesort(a, 0, a.length - 1);
        return count;
    }

    void mergesort(int[] a, int s, int e){
        if(s == e) return;
        int m = (s+e)/2;
        mergesort(a, s, m);
        mergesort(a, m+1, e);
        countReversePair(a, s, m, e);
        merge(a, s, m, e);
    }

    void countReversePair(int[] a, int s, int m, int e){
        int j = m + 1;
        for(int i = s; i <= m; i++){
            while(j <= e && a[i] > 2L * a[j]) j++;
            count+= j - (m + 1);
        }
    }

    void merge(int[] a, int s, int m, int e){
        int i = s;
        int j = m+1;
        List<Integer> list = new ArrayList<Integer>();
        while(i <= m && j <= e){
            if(a[i] > a[j]){
                list.add(a[j]);j++;
            }else{
                list.add(a[i]);i++;
            }
        }
        while(i <= m) { list.add(a[i]); i++; }
        while(j <= e) { list.add(a[j]); j++; }
        i = 0;
        for(int k = s; k <= e; k++){
            a[k] = list.get(i);
            i++;
        }
    }
}