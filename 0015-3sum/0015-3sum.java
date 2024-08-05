class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length, j, k;
        for(int i = 0; i <=n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            j = i+1;
            k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    list.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;

                    j++;
                    k--;
                }
                else if(sum > target){
                    k--;
                }
                // sum < target
                else{
                    j++;
                }
            }
        }
        return list;
    }
    
    public List<List<Integer>> threeSum_(int[] nums) {
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = null;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            set = new HashSet<>();
            for(int j = i+1; j < n; j++){
                int rest = target - (nums[i] + nums[j]);
                if(set.contains(rest)){
                    list.add(Arrays.asList(nums[i] , nums[j] , rest));
                }
                set.add(nums[j]);
            }
        }
        return list;
    }
}