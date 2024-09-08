class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = a.length;
        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && i - dq.peekFirst() + 1 > k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && a[ dq.peekLast() ] < a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(!dq.isEmpty() && i >= k-1){
                list.add ( a[ dq.peekFirst()] );
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}