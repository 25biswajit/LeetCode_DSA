class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        return maxSlidingWindowDQ(arr,k);
    }

    public int[] maxSlidingWindowDQ(int[] arr, int k) {
        int n = arr.length;
        List<Integer> out = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            //step 1 : Check window Size if greater remove from front
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            //step 2: Check Last Elem < ith Elem ; remove from end
            while(!dq.isEmpty() && arr[ dq.peekLast() ] < arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i >= k - 1 && !dq.isEmpty()){
                out.add( arr[ dq.peekFirst() ]);
            }
        }
        return out.stream().mapToInt(num->num).toArray();
    }

    public int[] maxSlidingWindowNaive(int[] a, int k) {
        int n = a.length;
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> out = new ArrayList<Integer>();
        int i = 0;
        while(i < k){
            list.add(a[i]);
            i++;
        }

        int max = findMax(list);
        out.add(max);
        int s = 1, e = i;

        while(e < n){
            list.remove(0);
            list.add(a[e]);
            max = findMax(list);
            out.add(max);
            s++;
            e++;
        }

        return out.stream().mapToInt(num->num).toArray();
    }

    private int findMax(List<Integer> list){
        if(list.isEmpty()) return -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            max = Integer.max(max, list.get(i));
        }
        return max;
    }
}