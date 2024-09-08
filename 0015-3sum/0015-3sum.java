class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        int n = a.length;
        for(int i = 0; i < n-2; i++){
            if(i > 0 && a[i] == a[i-1]) continue;
            int l = i+1, h = n-1;
            while(l < h){
                int sum = a[i] + a[l] + a[h];
                if(sum == 0){
                    List<Integer> list = Arrays.asList(a[i], a[l], a[h]);
                    ans.add(list);
                    while(l < h && a[l] == a[l+1]) l++;
                    while(l < h && a[h] == a[h-1]) h--;
                    l++;
                    h--;
                }
                else if(sum < 0){
                    l++;
                }
                else{//sum > 0
                    h--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_1(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = a.length;
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(a[i]+a[j]+a[k] == 0){
                        List<Integer> list = Arrays.asList(a[i], a[j], a[k]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}