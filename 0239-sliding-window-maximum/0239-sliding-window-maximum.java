class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        // add to back , delete from front
        Deque<Integer> dq = new ArrayDeque<>();
        int n = a.length;
        for(int i = 0; i < n;i++){
            // if window is over then delete from Front
            if(!dq.isEmpty() && i - dq.peekFirst() + 1 > k){
                dq.pollFirst();
            }

            // if dp.front i.e. max < current, delete max
            while(!dq.isEmpty() && a [ dq.peekLast() ]  < a[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i >= k-1 && !dq.isEmpty()){
                list.add(a[ dq.peekFirst() ]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}