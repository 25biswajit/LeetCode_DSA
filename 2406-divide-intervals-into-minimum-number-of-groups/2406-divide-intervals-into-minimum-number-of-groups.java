class Solution {
    public int minGroups(int[][] intervals) {
        //Arrays.sort( intervals, (a,b)->a[0]-b[0]);

        List<Interval> list = new ArrayList<>();
        for(int[] p : intervals){
            list.add(new Interval(p[0], false));
            list.add(new Interval(p[1], true));
        }

        Collections.sort(list, (a, b)-> {
            if (a.val == b.val) {
                return Boolean.compare(a.flag, b.flag);
            }
            return Integer.compare(a.val, b.val);
        });

        int max = 0, count = 0;
        for(Interval p : list){
            if(p.flag){
                count--;
            }else{
                count++;
            }
            max = Integer.max(max, count);
        }
        return max;
    }
}
class Interval{
    int val;
    boolean flag; // start false, end true

    Interval(int val, boolean flag){
        this.val = val;
        this.flag = flag;
    }
}