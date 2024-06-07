class Solution {
    public int largestInteger(int num) {
        Comparator<Integer> compare = (a,b) -> a - b;
        PriorityQueue<Integer> odds = new PriorityQueue<>(compare);
        PriorityQueue<Integer> evens = new PriorityQueue<>(compare);

        List<Integer> list = new ArrayList<>();
        //65875
        int num_ = num;
        while(num_ > 0){
            int dig = num_ % 10;
            if(dig % 2 == 0) evens.add(dig);
            else odds.add(dig);
            num_ = num_ / 10;
        }
        int ans = 0;
        while(num > 0){
            int dig = num % 10;
            dig = (num % 2 == 0) ? evens.poll() : odds.poll();
            list.add(dig);
            num = num / 10;
        }

        for(int i = list.size()-1; i >=0; i--){
            ans = ans * 10 + list.get(i);
        }
        
        return ans;
        
    }
}